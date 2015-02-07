package com.blunderer.materialdesignlibrary.activities;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.NavigationDrawerAdapter;
import com.blunderer.materialdesignlibrary.adapters.NavigationDrawerBottomAdapter;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItem;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemBottom;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemNormal;

import java.util.ArrayList;
import java.util.List;

public abstract class NavigationDrawerActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private View mDrawerLeft;
    private NavigationDrawerItemNormal mCurrentItem;
    private ListView mDrawerListView;
    private List<NavigationDrawerItem> mNavigationDrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLeft = findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                if (mCurrentItem != null) {
                    getSupportActionBar().setTitle(mCurrentItem.getTitleResource());
                }
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
            }

        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mNavigationDrawerItems = getNavigationDrawerTopHandler().getNavigationDrawerTopItems();
        if (mNavigationDrawerItems == null)
            mNavigationDrawerItems = new ArrayList<>();

        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(this, R.layout.navigation_drawer_row, mNavigationDrawerItems);
        mDrawerListView = (ListView) findViewById(R.id.left_drawer_listview);
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NavigationDrawerItem item = (NavigationDrawerItem) adapterView.getAdapter().getItem(i);
                if (item instanceof NavigationDrawerItemNormal) {
                    Fragment fragment = ((NavigationDrawerItemNormal) item).getFragment();
                    if (mCurrentItem.getFragment() != fragment) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragment_container, fragment).commit();
                        mCurrentItem = (NavigationDrawerItemNormal) item;
                    }
                    getSupportActionBar().setTitle(item.getTitleResource());
                    mDrawerListView.setItemChecked(i, true);
                    mDrawerLayout.closeDrawer(mDrawerLeft);
                }
            }

        });

        List<NavigationDrawerItemBottom> navigationDrawerItemsBottom = getNavigationDrawerBottomHandler().getNavigationDrawerBottomItems();
        if (navigationDrawerItemsBottom == null)
            navigationDrawerItemsBottom = new ArrayList<>();
        NavigationDrawerBottomAdapter bottomAdapter = new NavigationDrawerBottomAdapter(this, R.layout.navigation_drawer_row, navigationDrawerItemsBottom);
        final ListView mDrawerBottomListView = (ListView) findViewById(R.id.left_drawer_bottom_listview);
        mDrawerBottomListView.setAdapter(bottomAdapter);
        mDrawerBottomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mDrawerLayout.closeDrawer(findViewById(R.id.left_drawer));
                View.OnClickListener onClickListener = ((NavigationDrawerItemBottom) adapterView.getAdapter().getItem(i)).getOnClickListener();
                if (onClickListener != null)
                    onClickListener.onClick(view);
            }

        });
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            mDrawerBottomListView.setBackgroundResource(R.drawable.navigation_drawer_bottom_shadow);

        initFragment(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current_fragment_position", mDrawerListView.getCheckedItemPosition());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void initFragment(Bundle savedInstanceState) {
        if (mNavigationDrawerItems.size() <= 0)
            return;

        int fragmentPosition;
        if (savedInstanceState != null)
            fragmentPosition = savedInstanceState.getInt("current_fragment_position", 0);
        else
            fragmentPosition = defaultNavigationDrawerItemSelectedPosition();

        if (fragmentPosition < 0 || fragmentPosition >= mNavigationDrawerItems.size())
            fragmentPosition = 0;

        mDrawerListView.setItemChecked(fragmentPosition, true);
        NavigationDrawerItem item = mNavigationDrawerItems.get(fragmentPosition);
        if (item instanceof NavigationDrawerItemNormal) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, ((NavigationDrawerItemNormal) item).getFragment()).commit();
            mCurrentItem = (NavigationDrawerItemNormal) item;
            getSupportActionBar().setTitle(item.getTitleResource());
        } else {
            for (NavigationDrawerItem navItem : mNavigationDrawerItems) {
                if (navItem instanceof NavigationDrawerItemNormal) {
                    mCurrentItem = (NavigationDrawerItemNormal) navItem;
                    getSupportActionBar().setTitle(item.getTitleResource());
                    break;
                }
            }
        }
    }

    protected abstract NavigationDrawerTopHandler getNavigationDrawerTopHandler();

    protected abstract NavigationDrawerBottomHandler getNavigationDrawerBottomHandler();

    protected abstract int defaultNavigationDrawerItemSelectedPosition();

}

package com.blunderer.materialdesignlibrary.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.ViewPagerWithTabsAdapter;
import com.blunderer.materialdesignlibrary.models.ViewPagerItem;

import java.util.List;

public abstract class ViewPagerWithTabsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_with_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<ViewPagerItem> viewPagerItems = getViewPagerItems();
        if (viewPagerItems != null && viewPagerItems.size() > 0) {
            ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
            pager.setAdapter(new ViewPagerWithTabsAdapter(this, getSupportFragmentManager(), viewPagerItems));
            int defaultViewPagerItemSelectedPosition = defaultViewPagerItemSelectedPosition();
            if (defaultViewPagerItemSelectedPosition >= 0 && defaultViewPagerItemSelectedPosition < viewPagerItems.size())
                pager.setCurrentItem(defaultViewPagerItemSelectedPosition);

            PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
            tabs.setTextColor(getResources().getColor(android.R.color.white));
            tabs.setViewPager(pager);
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                tabs.setTabBackground(android.R.attr.selectableItemBackground);
        }
    }

    protected abstract List<ViewPagerItem> getViewPagerItems();

    protected abstract int defaultViewPagerItemSelectedPosition();

}

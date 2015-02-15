package com.blunderer.materialdesignlibrary.sample;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewNormalActivity;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewWithLeftImageActivity;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewWithTopImageActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewWithCustomLayoutActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewWithRefreshActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewWithRefreshAndCustomLayoutActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerWithIndicatorActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    @Override
    protected ListAdapter getListAdapter() {
        return new MainActivityAdapter(this, R.layout.activity_main_row, getFeatures());
    }

    @Override
    protected boolean useCustomContentView() {
        return false;
    }

    @Override
    protected int getCustomContentView() {
        return 0;
    }

    @Override
    protected boolean pullToRefreshList() {
        return false;
    }

    @Override
    protected int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    protected void onRefresh() {
    }

    @Override
    protected void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, ((MainActivityFeature) adapterView.getAdapter().getItem(position)).getActivity());
        startActivity(intent);
    }

    @Override
    protected boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/DenisMondon/material-design-library"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<MainActivityFeature> getFeatures() {
        MainActivityFeature navigationDrawerHeader = new MainActivityFeature();
        navigationDrawerHeader.setHeader(true);
        navigationDrawerHeader.setTitle("NavigationDrawer");
        MainActivityFeature navigationDrawerFeature1 = new MainActivityFeature();
        navigationDrawerFeature1.setActivity(NavigationDrawerActivity.class);
        navigationDrawerFeature1.setTitle("Normal");
        navigationDrawerFeature1.setDescription("A basic NavigationDrawer");

        MainActivityFeature listViewHeader = new MainActivityFeature();
        listViewHeader.setHeader(true);
        listViewHeader.setTitle("ListView");
        MainActivityFeature listViewFeature1 = new MainActivityFeature();
        listViewFeature1.setActivity(ListViewActivity.class);
        listViewFeature1.setTitle("Normal");
        listViewFeature1.setDescription("A basic ListView");
        MainActivityFeature listViewFeature2 = new MainActivityFeature();
        listViewFeature2.setActivity(ListViewWithCustomLayoutActivity.class);
        listViewFeature2.setTitle("With Custom Layout");
        listViewFeature2.setDescription("A ListView with a custom Layout");
        MainActivityFeature listViewFeature3 = new MainActivityFeature();
        listViewFeature3.setActivity(ListViewWithRefreshActivity.class);
        listViewFeature3.setTitle("With Pull To Refresh");
        listViewFeature3.setDescription("A ListView with a pull to refresh");
        MainActivityFeature listViewFeature4 = new MainActivityFeature();
        listViewFeature4.setActivity(ListViewWithRefreshAndCustomLayoutActivity.class);
        listViewFeature4.setTitle("With Custom Layout & Pull To Refresh");
        listViewFeature4.setDescription("A ListView with a custom layout & a pull to refresh");

        MainActivityFeature viewPagerHeader = new MainActivityFeature();
        viewPagerHeader.setHeader(true);
        viewPagerHeader.setTitle("ViewPager");
        MainActivityFeature viewPagerFeature1 = new MainActivityFeature();
        viewPagerFeature1.setActivity(ViewPagerActivity.class);
        viewPagerFeature1.setTitle("Normal");
        viewPagerFeature1.setDescription("A basic ViewPager");
        MainActivityFeature viewPagerFeature2 = new MainActivityFeature();
        viewPagerFeature2.setActivity(ViewPagerWithIndicatorActivity.class);
        viewPagerFeature2.setTitle("With Indicator");
        viewPagerFeature2.setDescription("A ViewPager with an Indicator");

        MainActivityFeature cardviewHeader = new MainActivityFeature();
        cardviewHeader.setHeader(true);
        cardviewHeader.setTitle("CardView");
        MainActivityFeature cardviewFeature1 = new MainActivityFeature();
        cardviewFeature1.setActivity(CardViewNormalActivity.class);
        cardviewFeature1.setTitle("Normal");
        cardviewFeature1.setDescription("A basic CardView");
        MainActivityFeature cardviewFeature2 = new MainActivityFeature();
        cardviewFeature2.setActivity(CardViewWithLeftImageActivity.class);
        cardviewFeature2.setTitle("Left Image");
        cardviewFeature2.setDescription("A CardView with an Image on the left");
        MainActivityFeature cardviewFeature3 = new MainActivityFeature();
        cardviewFeature3.setActivity(CardViewWithTopImageActivity.class);
        cardviewFeature3.setTitle("Top Image");
        cardviewFeature3.setDescription("A CardView with an Image on the top");

        List<MainActivityFeature> objects = new ArrayList<>();
        objects.add(navigationDrawerHeader);
        objects.add(navigationDrawerFeature1);
        objects.add(listViewHeader);
        objects.add(listViewFeature1);
        objects.add(listViewFeature2);
        objects.add(listViewFeature3);
        objects.add(listViewFeature4);
        objects.add(viewPagerHeader);
        objects.add(viewPagerFeature1);
        objects.add(viewPagerFeature2);
        objects.add(cardviewHeader);
        objects.add(cardviewFeature1);
        objects.add(cardviewFeature2);
        objects.add(cardviewFeature3);

        return objects;
    }

}

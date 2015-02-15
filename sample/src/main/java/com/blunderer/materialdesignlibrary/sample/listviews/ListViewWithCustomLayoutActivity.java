package com.blunderer.materialdesignlibrary.sample.listviews;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.sample.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewWithCustomLayoutActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    @Override
    protected ListAdapter getListAdapter() {
        return new ArrayAdapter<>(
                this,
                R.layout.activity_listview_row,
                new ArrayList<>(Arrays.asList(
                        getString(R.string.title_item1),
                        getString(R.string.title_item2),
                        getString(R.string.title_item3)
                ))
        );
    }

    @Override
    protected boolean useCustomContentView() {
        return true;
    }

    @Override
    protected int getCustomContentView() {
        return R.layout.activity_listview_with_custom_layout;
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
    }

    @Override
    protected boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item " + (position + 1) + " long clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

}

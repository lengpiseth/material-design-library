package com.blunderer.materialdesignlibrary.sample.listviews;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.sample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewWithRefreshAndCustomLayoutActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    private List<String> mObjects;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected ListAdapter getListAdapter() {
        mObjects = new ArrayList<>(Arrays.asList("Item 1", "Item 2", "Item 3"));
        return (mAdapter = new ArrayAdapter<>(this, R.layout.activity_listview_row, mObjects));
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
        return true;
    }

    @Override
    protected int[] getPullToRefreshColorResources() {
        return new int[]{R.color.color_primary};
    }

    @Override
    protected void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mObjects.add("Item " + (mObjects.size() + 1));
                mAdapter.notifyDataSetChanged();
                setRefreshing(false);
            }

        }, 2000);
    }

    @Override
    protected void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item #" + position + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item #" + position + " long clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

}

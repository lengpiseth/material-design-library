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

public class ListViewWithRefreshActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    private List<String> mObjects;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected ListAdapter getListAdapter() {
        mObjects = new ArrayList<>(Arrays.asList(
                getString(R.string.title_item1),
                getString(R.string.title_item2),
                getString(R.string.title_item3)
        ));
        return (mAdapter = new ArrayAdapter<>(this, R.layout.activity_listview_row, mObjects));
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
    }

    @Override
    protected boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item " + (position + 1) + " long clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

}

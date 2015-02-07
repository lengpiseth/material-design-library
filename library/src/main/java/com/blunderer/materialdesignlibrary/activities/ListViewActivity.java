package com.blunderer.materialdesignlibrary.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.blunderer.materialdesignlibrary.R;

public abstract class ListViewActivity extends ActionBarActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListViewActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mActivity = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewStub stub = (ViewStub) findViewById(R.id.activity_listview_view);
        View inflatedView;
        ListView listView;
        try {
            stub.setLayoutResource(useCustomContentView() ? getCustomContentView() : R.layout.listview);
            inflatedView = stub.inflate();
            if (inflatedView instanceof ListView)
                listView = (ListView) inflatedView;
            else
                listView = (ListView) inflatedView.findViewById(android.R.id.list);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("CustomContentView must have a valid layoutResource");
        }

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_listview_with_refresh_refresh);
        if (pullToRefreshList()) {
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

                @Override
                public void onRefresh() {
                    mActivity.onRefresh();
                }

            });
            mSwipeRefreshLayout.setColorSchemeResources(getPullToRefreshColorResources());
        } else
            mSwipeRefreshLayout.setEnabled(false);

        if (listView != null) {
            ListAdapter adapter = getListAdapter();
            if (adapter != null) {
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        mActivity.onItemClick(adapterView, view, position, id);
                    }

                });
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                        return mActivity.onItemLongClick(adapterView, view, position, id);
                    }

                });
            }
        }
    }

    protected void setRefreshing(boolean refreshing) {
        if (mSwipeRefreshLayout != null)
            mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    protected abstract ListAdapter getListAdapter();

    protected abstract boolean useCustomContentView();

    /**
     * Return a custom content view.
     * The layout MUST contain a ListView with android:id="@android:id/list".
     * The method "useCustomContentView()" MUST return true.
     *
     * @return a resource
     */
    protected abstract int getCustomContentView();

    protected abstract boolean pullToRefreshList();

    protected abstract int[] getPullToRefreshColorResources();

    protected abstract void onRefresh();

    protected abstract void onItemClick(AdapterView<?> adapterView, View view, int position, long l);

    protected abstract boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l);

}
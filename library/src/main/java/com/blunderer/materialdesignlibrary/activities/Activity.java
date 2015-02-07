package com.blunderer.materialdesignlibrary.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

import com.blunderer.materialdesignlibrary.R;

public abstract class Activity extends ActionBarActivity {

    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewStub stub = (ViewStub) findViewById(R.id.view_stub);
        stub.setLayoutResource(getContentView());
        mView = stub.inflate();
    }

    @Override
    public View findViewById(int id) {
        if (mView != null)
            return mView.findViewById(id);
        return super.findViewById(id);
    }

    protected abstract int getContentView();

}
package com.blunderer.materialdesignlibrary.models;

import android.support.v4.app.Fragment;

public class ViewPagerItem {

    private int mTitleResource;
    private Fragment mFragment;

    public int getTitleResource() {
        return mTitleResource;
    }

    public void setTitleResource(int titleResource) {
        this.mTitleResource = titleResource;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

}

package com.blunderer.materialdesignlibrary.models;

public abstract class NavigationDrawerItem {

    protected int mTitleResource;

    protected boolean mUseTitleResource = false;

    public int getTitleResource() {
        return mTitleResource;
    }

    public void setTitleResource(int titleResource) {
        mUseTitleResource = true;
        mTitleResource = titleResource;
    }

    public boolean useTitleResource() {
        return mUseTitleResource;
    }

}

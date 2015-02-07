package com.blunderer.materialdesignlibrary.models;

import android.support.v4.app.Fragment;
import android.view.View;

public class NavigationDrawerItemNormal extends NavigationDrawerItem {

    private int mIconResource;
    private View.OnClickListener mOnClickListener;
    private Fragment mFragment;

    private boolean mUseIconResource = false;

    public int getIconResource() {
        return mIconResource;
    }

    public void setIconResource(int iconResource) {
        mUseIconResource = true;
        mIconResource = iconResource;
    }

    public View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public boolean useIconResource() {
        return mUseIconResource;
    }

}

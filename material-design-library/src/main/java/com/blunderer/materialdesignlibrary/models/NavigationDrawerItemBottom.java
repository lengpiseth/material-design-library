package com.blunderer.materialdesignlibrary.models;

import android.view.View;

import com.blunderer.materialdesignlibrary.R;

public class NavigationDrawerItemBottom extends NavigationDrawerItem {

    public final static int CUSTOM = -1;
    public final static int SETTINGS = 0;
    public final static int HELP_AND_FEEDBACK = 1;

    private int mIconResource;
    private View.OnClickListener mOnClickListener;

    private boolean mUseIconResource = false;

    public NavigationDrawerItemBottom(int definedTool) {
        switch (definedTool) {
            case SETTINGS:
                mTitleResource = R.string.settings;
                mIconResource = R.drawable.ic_settings;
                mUseTitleResource = true;
                mUseIconResource = true;
                break;
            case HELP_AND_FEEDBACK:
                mTitleResource = R.string.help_and_feedback;
                mIconResource = R.drawable.ic_help;
                mUseTitleResource = true;
                mUseIconResource = true;
                break;
            default:
                break;
        }
    }

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

    public boolean useIconResource() {
        return mUseIconResource;
    }

}

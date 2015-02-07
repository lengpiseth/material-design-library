package com.blunderer.materialdesignlibrary.handlers;

import android.view.View;

import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemBottom;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerBottomHandler {

    private List<NavigationDrawerItemBottom> mItems;

    public NavigationDrawerBottomHandler() {
        mItems = new ArrayList<>();
    }

    public NavigationDrawerBottomHandler addSettings(View.OnClickListener onClickListener) {
        NavigationDrawerItemBottom item = new NavigationDrawerItemBottom(NavigationDrawerItemBottom.SETTINGS);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addHelpAndFeedback(View.OnClickListener onClickListener) {
        NavigationDrawerItemBottom item = new NavigationDrawerItemBottom(NavigationDrawerItemBottom.HELP_AND_FEEDBACK);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource, int iconResource, View.OnClickListener onClickListener) {
        NavigationDrawerItemBottom item = new NavigationDrawerItemBottom(NavigationDrawerItemBottom.CUSTOM);
        item.setTitleResource(titleResource);
        item.setIconResource(iconResource);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public List<NavigationDrawerItemBottom> getNavigationDrawerBottomItems() {
        return mItems;
    }

}

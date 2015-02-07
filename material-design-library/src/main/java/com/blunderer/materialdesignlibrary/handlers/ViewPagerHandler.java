package com.blunderer.materialdesignlibrary.handlers;

import android.support.v4.app.Fragment;

import com.blunderer.materialdesignlibrary.models.ViewPagerItem;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHandler {

    private List<ViewPagerItem> mItems;

    public ViewPagerHandler() {
        mItems = new ArrayList<>();
    }

    public ViewPagerHandler addPage(int titleResource, Fragment fragment) {
        ViewPagerItem item = new ViewPagerItem();
        item.setTitleResource(titleResource);
        item.setFragment(fragment);
        mItems.add(item);
        return this;
    }

    public List<ViewPagerItem> getViewPagerItems() {
        return mItems;
    }
}

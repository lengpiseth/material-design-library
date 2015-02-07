package com.blunderer.materialdesignlibrary.handlers;

import android.support.v4.app.Fragment;

import com.blunderer.materialdesignlibrary.models.NavigationDrawerItem;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemHeader;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemNormal;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerTopHandler {

    private List<NavigationDrawerItem> mItems;

    public NavigationDrawerTopHandler() {
        mItems = new ArrayList<>();
    }

    public NavigationDrawerTopHandler addSection(int titleResource) {
        NavigationDrawerItemHeader item = new NavigationDrawerItemHeader();
        item.setTitleResource(titleResource);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerTopHandler addItem(int titleResource, int iconResource, Fragment fragment) {
        NavigationDrawerItemNormal item = new NavigationDrawerItemNormal();
        item.setTitleResource(titleResource);
        item.setIconResource(iconResource);
        item.setFragment(fragment);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerTopHandler addItem(int titleResource, Fragment fragment) {
        NavigationDrawerItemNormal item = new NavigationDrawerItemNormal();
        item.setTitleResource(titleResource);
        item.setFragment(fragment);
        mItems.add(item);
        return this;
    }

    public List<NavigationDrawerItem> getNavigationDrawerTopItems() {
        return mItems;
    }

}

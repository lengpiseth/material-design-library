package com.blunderer.materialdesignlibrary.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.blunderer.materialdesignlibrary.models.ViewPagerItem;

import java.util.List;

public class ViewPagerWithTabsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<ViewPagerItem> mViewPagerItems;

    public ViewPagerWithTabsAdapter(Context context, FragmentManager fm, List<ViewPagerItem> viewPagerItems) {
        super(fm);

        mContext = context;
        mViewPagerItems = viewPagerItems;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(mViewPagerItems.get(position).getTitleResource());
    }

    @Override
    public int getCount() {
        return mViewPagerItems.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mViewPagerItems.get(position).getFragment();
    }

}
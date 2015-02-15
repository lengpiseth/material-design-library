package com.blunderer.materialdesignlibrary.sample.viewpagers;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.blunderer.materialdesignlibrary.sample.MainFragment;
import com.blunderer.materialdesignlibrary.sample.R;

public class ViewPagerActivity extends com.blunderer.materialdesignlibrary.activities.ViewPagerActivity {

    @Override
    protected ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler()
                .addPage(R.string.title_section1, MainFragment.newInstance("Material Design ViewPager"))
                .addPage(R.string.title_section2, MainFragment.newInstance("Material Design ViewPager"));
    }

    @Override
    protected boolean showViewPagerIndicator() {
        return false;
    }

    @Override
    protected boolean replaceActionBarTitleByViewPagerItemTitle() {
        return true;
    }

    @Override
    protected int defaultViewPagerItemSelectedPosition() {
        return 0;
    }

}

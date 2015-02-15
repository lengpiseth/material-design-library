package com.blunderer.materialdesignlibrary.sample.navigationdrawers;

import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.sample.MainFragment;
import com.blunderer.materialdesignlibrary.sample.R;

public class NavigationDrawerActivity extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    @Override
    protected NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        return new NavigationDrawerTopHandler()
                .addSection(R.string.title_section1)
                .addItem(R.string.app_name, R.drawable.ic_help, MainFragment.newInstance("Material Design NavigationDrawer"))
                .addItem(R.string.settings, R.drawable.ic_settings, MainFragment.newInstance("Material Design NavigationDrawer"))
                .addSection(R.string.title_section2)
                .addItem(R.string.app_name, R.drawable.ic_help, MainFragment.newInstance("Material Design NavigationDrawer"))
                .addItem(R.string.settings, R.drawable.ic_settings, MainFragment.newInstance("Material Design NavigationDrawer"));
    }

    @Override
    protected NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler()
                .addSettings(null)
                .addHelpAndFeedback(null);
    }

    @Override
    protected int defaultNavigationDrawerItemSelectedPosition() {
        return 1;
    }

}

package com.blunderer.materialdesignlibrary.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.ViewPagerWithTabsAdapter;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.blunderer.materialdesignlibrary.models.ViewPagerItem;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

public abstract class ViewPagerFragment extends Fragment {

    private List<ViewPagerItem> viewPagerItems;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            replaceTitle(viewPagerItems.get(position).getTitleResource());
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    };

    public ViewPagerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPagerItems = getViewPagerHandler().getViewPagerItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onCreateView ViewPagerFragment", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        if (viewPagerItems != null && viewPagerItems.size() > 0) {
            ViewPager pager = (ViewPager) view.findViewById(R.id.viewpager);
            pager.setAdapter(new ViewPagerWithTabsAdapter(getActivity(), getActivity().getSupportFragmentManager(), viewPagerItems));
            int defaultViewPagerItemSelectedPosition = defaultViewPagerItemSelectedPosition();
            if (defaultViewPagerItemSelectedPosition >= 0 && defaultViewPagerItemSelectedPosition < viewPagerItems.size())
                pager.setCurrentItem(defaultViewPagerItemSelectedPosition);

            if (!showViewPagerIndicator()) {
                pager.setOnPageChangeListener(mOnPageChangeListener);
            } else {
                CirclePageIndicator viewPagerIndicator = (CirclePageIndicator) view.findViewById(R.id.viewpagerindicator);
                viewPagerIndicator.setViewPager(pager);
                viewPagerIndicator.setVisibility(View.VISIBLE);
                viewPagerIndicator.setOnPageChangeListener(mOnPageChangeListener);
            }

            replaceTitle(viewPagerItems.get(0).getTitleResource());
        }
        return view;
    }

    private void replaceTitle(int titleResource) {
//        if (replaceActionBarTitleByViewPagerItemTitle())
//            get.getSupportActionBar().setTitle(titleResource);
    }

    protected abstract ViewPagerHandler getViewPagerHandler();

    protected abstract boolean showViewPagerIndicator();

    protected abstract boolean replaceActionBarTitleByViewPagerItemTitle();

    protected abstract int defaultViewPagerItemSelectedPosition();

}

package com.blunderer.materialdesignlibrary.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private static final String ARG_TEXT = "text";

    public MainFragment() {
    }

    public static MainFragment newInstance(String text) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview, container, false);
        if (getArguments() == null || TextUtils.isEmpty(getArguments().getString(ARG_TEXT)))
            throw new RuntimeException("PD !!!!!!!!!");
        ((TextView) view.findViewById(android.R.id.text1)).setText(getArguments().getString(ARG_TEXT));
        return view;
    }

}

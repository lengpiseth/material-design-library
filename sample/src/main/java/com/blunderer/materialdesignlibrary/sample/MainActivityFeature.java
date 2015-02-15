package com.blunderer.materialdesignlibrary.sample;

public class MainActivityFeature {

    private String mTitle;
    private String mDescription;
    private boolean mHeader;
    private Class mActivity;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public boolean isHeader() {
        return mHeader;
    }

    public void setHeader(boolean header) {
        this.mHeader = header;
    }

    public Class getActivity() {
        return mActivity;
    }

    public void setActivity(Class activity) {
        this.mActivity = activity;
    }

}

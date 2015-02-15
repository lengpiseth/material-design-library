package com.blunderer.materialdesignlibrary.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.R;
import com.joooonho.SelectableRoundedImageView;

public class CardView extends android.support.v7.widget.CardView {

    private Drawable mImage;
    private String mTitleText;
    private String mDescriptionText;
    private String mNormalButtonText;
    private String mHighlightButtonText;

    private OnClickListener mOnNormalButtonClickListener;
    private OnClickListener mOnHighlightButtonClickListener;

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MDLCardView, 0, 0);

        int imageType;
        try {
            imageType = a.getInt(R.styleable.MDLCardView_mdl_imagePosition, 0);
            mImage = a.getDrawable(R.styleable.MDLCardView_mdl_image);
            mTitleText = a.getString(R.styleable.MDLCardView_mdl_title);
            mDescriptionText = a.getString(R.styleable.MDLCardView_mdl_description);
            mNormalButtonText = a.getString(R.styleable.MDLCardView_mdl_normalButton);
            mHighlightButtonText = a.getString(R.styleable.MDLCardView_mdl_highlightButton);
        } finally {
            a.recycle();
        }

        setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
        setPreventCornerOverlap(false);
        setCardBackgroundColor(context.getResources().getColor(R.color.cardview_background));

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (imageType == 1 && mImage != null)
            inflateCardViewImageLeft(inflater);
        else if (imageType == 2 && mImage != null)
            inflateCardViewImageTop(inflater);
        else
            inflateCardViewNormal(inflater);
    }

    private void inflateCardViewNormal(LayoutInflater inflater) {
        inflater.inflate(R.layout.cardview_normal, this, true);

        LinearLayout layout = (LinearLayout) getChildAt(0);

        handleTitle(layout, 0);
        handleDescription(layout, 1);
        handleSpacing(layout, 2);
        handleCardViewNormalAndImageLeftButtons(layout, 3);
    }

    private void inflateCardViewImageLeft(LayoutInflater inflater) {
        inflater.inflate(R.layout.cardview_image_left, this, true);

        LinearLayout layoutAll = (LinearLayout) getChildAt(0);
        handleImage(layoutAll, 0);

        LinearLayout layout = (LinearLayout) layoutAll.getChildAt(1);
        handleTitle(layout, 0);
        handleDescription(layout, 1);
        handleSpacing(layout, 2);
        handleCardViewNormalAndImageLeftButtons(layout, 3);
    }

    private void inflateCardViewImageTop(LayoutInflater inflater) {
        inflater.inflate(R.layout.cardview_image_top, this, true);

        LinearLayout layoutAll = (LinearLayout) getChildAt(0);
        RelativeLayout layoutImageTitle = (RelativeLayout) layoutAll.getChildAt(0);
        handleImage(layoutImageTitle, 0);
        handleTitle(layoutImageTitle, 1);

        LinearLayout layout = (LinearLayout) layoutAll.getChildAt(1);
        handleDescription(layout, 0);
        handleCardViewImageTopButtons(layout, 1);
    }

    private void handleImage(ViewGroup layout, int position) {
        SelectableRoundedImageView image = (SelectableRoundedImageView) layout.getChildAt(position);
        image.setImageDrawable(mImage);
        if (TextUtils.isEmpty(mDescriptionText) && TextUtils.isEmpty(mNormalButtonText) && TextUtils.isEmpty(mHighlightButtonText))
            image.setCornerRadiiDP(2, 2, 2, 2);
    }

    private void handleTitle(ViewGroup layout, int position) {
        if (!TextUtils.isEmpty(mTitleText)) {
            TextView title = (TextView) layout.getChildAt(position);
            title.setText(mTitleText);
            title.setVisibility(VISIBLE);
        }
    }

    private void handleDescription(ViewGroup layout, int position) {
        if (!TextUtils.isEmpty(mDescriptionText)) {
            TextView description = (TextView) layout.getChildAt(position);
            description.setText(mDescriptionText);
            description.setVisibility(VISIBLE);
        }
    }

    private void handleCardViewNormalAndImageLeftButtons(ViewGroup layout, int position) {
        if (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText)) {
            View separatorButtons = layout.getChildAt(position);
            if (!TextUtils.isEmpty(mTitleText) || !TextUtils.isEmpty(mDescriptionText))
                separatorButtons.setVisibility(VISIBLE);
            else
                layout.setPadding(layout.getPaddingLeft(), 0, layout.getPaddingRight(), layout.getPaddingBottom());

            handleButtons(layout, position);
        }
    }

    private void handleCardViewImageTopButtons(ViewGroup layout, int position) {
        if (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText)) {
            View separatorButtons = layout.getChildAt(position);
            if (!TextUtils.isEmpty(mDescriptionText))
                separatorButtons.setVisibility(VISIBLE);

            handleButtons(layout, position);
        }
    }

    private void handleButtons(ViewGroup layout, int position) {
        LinearLayout buttonsLayout = (LinearLayout) layout.getChildAt(position + 1);
        buttonsLayout.setVisibility(VISIBLE);

        if (!TextUtils.isEmpty(mNormalButtonText)) {
            Button normalButton = (Button) buttonsLayout.getChildAt(0);
            normalButton.setText(mNormalButtonText);
            normalButton.setVisibility(VISIBLE);
            normalButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (mOnNormalButtonClickListener != null)
                        mOnNormalButtonClickListener.onClick(view);
                }

            });
        }

        if (!TextUtils.isEmpty(mHighlightButtonText)) {
            Button highlightButton = (Button) buttonsLayout.getChildAt(1);
            highlightButton.setText(mHighlightButtonText);
            highlightButton.setVisibility(VISIBLE);
            highlightButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (mOnHighlightButtonClickListener != null)
                        mOnHighlightButtonClickListener.onClick(view);
                }

            });
        }
    }

    private void handleSpacing(ViewGroup layout, int position) {
        View spacingView = layout.getChildAt(position);
        int spacingViewHeight = 0;
        if (!TextUtils.isEmpty(mTitleText) && TextUtils.isEmpty(mDescriptionText) && TextUtils.isEmpty(mNormalButtonText) && TextUtils.isEmpty(mHighlightButtonText))
            spacingViewHeight = 6;
        else if (!TextUtils.isEmpty(mTitleText) && TextUtils.isEmpty(mDescriptionText) && (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText)))
            spacingViewHeight = 10;
        else if (TextUtils.isEmpty(mTitleText) && TextUtils.isEmpty(mDescriptionText) && TextUtils.isEmpty(mNormalButtonText) && TextUtils.isEmpty(mHighlightButtonText))
            spacingViewHeight = 2;
        else if (!TextUtils.isEmpty(mDescriptionText) && (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText)))
            spacingViewHeight = 4;
        spacingView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, spacingViewHeight, getResources().getDisplayMetrics())));
    }

    public OnClickListener getOnNormalButtonClickListener() {
        return mOnNormalButtonClickListener;
    }

    public void setOnNormalButtonClickListener(OnClickListener onNormalButtonClickListener) {
        mOnNormalButtonClickListener = onNormalButtonClickListener;
    }

    public OnClickListener getOnHighlightButtonClickListener() {
        return mOnHighlightButtonClickListener;
    }

    public void setOnHighlightButtonClickListener(OnClickListener onHighlightButtonClickListener) {
        mOnHighlightButtonClickListener = onHighlightButtonClickListener;
    }

}

package com.blunderer.materialdesignlibrary.sample.cardviews;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.sample.R;
import com.blunderer.materialdesignlibrary.views.CardView;

public class CardViewWithLeftImageActivity extends com.blunderer.materialdesignlibrary.activities.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CardView cardview = (CardView) findViewById(R.id.cardview);
        cardview.setOnNormalButtonClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Normal button clicked!", Toast.LENGTH_SHORT).show();
            }

        });
        cardview.setOnHighlightButtonClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Highlight button clicked!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_cardview_with_left_image;
    }

}

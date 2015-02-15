package com.blunderer.materialdesignlibrary.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.sample.MainActivityFeature;
import com.blunderer.materialdesignlibrary.sample.R;

import java.util.List;

public class MainActivityAdapter extends ArrayAdapter<MainActivityFeature> {

    private int mLayoutResourceId;
    private int mCount;

    public MainActivityAdapter(Context context, int layoutResourceId, List<MainActivityFeature> objects) {
        super(context, layoutResourceId, objects);

        mLayoutResourceId = layoutResourceId;
        mCount = objects.size();
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return !getItem(position).isHeader();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        MainActivityFeature item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.activity_main_row_title);
            holder.header = (TextView) convertView.findViewById(R.id.activity_main_row_header);
            holder.description = (TextView) convertView.findViewById(R.id.activity_main_row_description);
            holder.headerSeparator = convertView.findViewById(R.id.activity_main_row_header_separator);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        if (item.isHeader()) {
            holder.header.setText(item.getTitle());
            holder.header.setVisibility(View.VISIBLE);
            if (position > 0)
                holder.headerSeparator.setVisibility(View.VISIBLE);
            else
                holder.headerSeparator.setVisibility(View.GONE);
            holder.title.setVisibility(View.GONE);
            holder.description.setVisibility(View.GONE);
        } else {
            holder.title.setText(item.getTitle());
            holder.title.setVisibility(View.VISIBLE);
            if (item.getDescription() == null || "".equals(item.getDescription()))
                holder.description.setVisibility(View.GONE);
            else {
                holder.description.setText(item.getDescription());
                holder.description.setVisibility(View.VISIBLE);
            }
            holder.header.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(View.GONE);
        }

        return convertView;
    }

    private class ViewHolder {

        private TextView title;
        private TextView header;
        private TextView description;
        private View headerSeparator;

    }

}

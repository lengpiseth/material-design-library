package com.blunderer.materialdesignlibrary.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItem;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemBottom;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemHeader;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerItemNormal;

import java.util.List;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerItem> {

    private int mLayoutResourceId;

    public NavigationDrawerAdapter(Context context, int layoutResourceId, List<NavigationDrawerItem> objects) {
        super(context, layoutResourceId, objects);

        mLayoutResourceId = layoutResourceId;
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
        return getItem(position) instanceof NavigationDrawerItemNormal;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        NavigationDrawerItem item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayoutResourceId, parent, false);
            if (item instanceof NavigationDrawerItemNormal || item instanceof NavigationDrawerItemBottom)
                convertView.setBackgroundResource(R.drawable.navigation_drawer_selector);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.navigation_drawer_row_title);
            holder.titleHeader = (TextView) convertView.findViewById(R.id.navigation_drawer_row_header);
            holder.icon = (ImageView) convertView.findViewById(R.id.navigation_drawer_row_icon);
            holder.headerSeparator = convertView.findViewById(R.id.navigation_drawer_row_header_separator);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();


        if (item.useTitleResource()) {
            try {
                holder.title.setText(item.getTitleResource());
                holder.titleHeader.setText(item.getTitleResource());
            } catch (Resources.NotFoundException e) {
            }
        }

        if (item instanceof NavigationDrawerItemNormal) {
            NavigationDrawerItemNormal itemNormal = (NavigationDrawerItemNormal) item;
            holder.title.setVisibility(View.VISIBLE);
            holder.titleHeader.setVisibility(View.GONE);
            holder.icon.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(View.GONE);
            if (itemNormal.useIconResource()) {
                try {
                    holder.icon.setImageResource(itemNormal.getIconResource());
                    holder.icon.setVisibility(View.VISIBLE);
                } catch (Resources.NotFoundException e) {
                }
            }
        } else if (item instanceof NavigationDrawerItemHeader) {
            holder.title.setVisibility(View.GONE);
            holder.titleHeader.setVisibility(View.VISIBLE);
            holder.icon.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
        }

        return convertView;
    }

    private class ViewHolder {

        private TextView title;
        private TextView titleHeader;
        private ImageView icon;
        private View headerSeparator;

    }

}

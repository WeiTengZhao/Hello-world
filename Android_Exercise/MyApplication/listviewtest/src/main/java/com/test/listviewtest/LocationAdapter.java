package com.test.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016-07-24.
 */
public class LocationAdapter extends ArrayAdapter<Location> {
    private int resourceId;
    public LocationAdapter (Context context, int textViewResourceId,
                            List<Location> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Location location = getItem(position);
        View view;
        ViewHolder viewHeader;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHeader = new ViewHolder();
            viewHeader.textView  = (TextView) view.findViewById(R.id.text_name);
            viewHeader.imageView = (ImageView) view.findViewById(R.id.image_id);
            view.setTag(viewHeader);
        }else {
            view = convertView;
            viewHeader = (ViewHolder)view.getTag();
        }

        viewHeader.textView.setText(location.getName());
        viewHeader.imageView.setImageResource(location.getImageId());
        return view;
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}


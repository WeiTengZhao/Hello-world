package com.example.shao.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by Shao on 2016/8/2.
 */
public class ListAdapter extends BaseAdapter {
    private int resourceId;
    private Context mcontext;
    private LayoutInflater inflater;
    private List<Map<String,String>> mlist;

    private List<New> newList;



    public ListAdapter(Context context, List<New> list, int ListViewresourceId) {
        mcontext = context;
        resourceId = ListViewresourceId;
        inflater = LayoutInflater.from(context);
        newList = list;
    }

    @Override
    public int getCount() {
        return newList.size();
    }

    @Override
    public Object getItem(int position) {
        return newList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        final ViewHolder viewHolder;
        New n = newList.get(position);
        if(convertView == null){ //判断缓存是否为空,空则存储，非空则读缓存
            v = inflater.inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (SmartImageView) v.findViewById(R.id.image);
            viewHolder.title = (TextView) v.findViewById(R.id.title);
            viewHolder.context = (TextView) v.findViewById(R.id.context);
            v.setTag(viewHolder);
        }else {
            v = convertView;
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.title.setText(n.getId());//通过mlist设置ListView文本内容
        viewHolder.context.setText(n.getTitle());
        try {
            if (n.getThumb() == "") {
                viewHolder.imageView.setImageResource(R.mipmap.icon);
            }else {
                viewHolder.imageView.setImageUrl(n.getThumb());
            }


        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return v;
    }

    class ViewHolder {          //定义内部类用于缓存
        SmartImageView imageView;
        TextView title;
        TextView context;
    }




}

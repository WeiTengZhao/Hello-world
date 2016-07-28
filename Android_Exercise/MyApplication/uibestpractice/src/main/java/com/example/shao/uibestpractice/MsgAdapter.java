package com.example.shao.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shao on 2016/7/28.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourceId;

    public MsgAdapter(Context context, int TextViewResourseid, List<Msg> object) {
        super(context,TextViewResourseid,object);
        resourceId = TextViewResourseid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Msg msg = getItem(position);
        if(convertView == null) {                                               //定义缓存
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.left_massage = (TextView) view.findViewById(R.id.left_massage);
            viewHolder.right_massage = (TextView) view.findViewById(R.id.right_massage);
            viewHolder.left_layout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.right_layout = (LinearLayout) view.findViewById(R.id.right_layout);
            view.setTag(viewHolder);
        }else {
            view = convertView;
           viewHolder = (ViewHolder) view.getTag();

        }

        if(msg.getType() == Msg.TYPE_RECEIVED) {                                //判断收发类型，收显左布局，隐藏右布局
            viewHolder.left_layout.setVisibility(View.VISIBLE);
            viewHolder.right_layout.setVisibility(View.GONE);
            viewHolder.left_massage.setText(msg.getcontext());
        }else if(msg.getType() == Msg.TYPR_SEND) {                              //发显右布局，隐左布局
            viewHolder.right_layout.setVisibility(View.VISIBLE);
            viewHolder.left_layout.setVisibility(View.GONE);
            viewHolder.right_massage.setText(msg.getcontext());
        }
        return view;
    }

    class ViewHolder {
        TextView left_massage;
        TextView right_massage;
        LinearLayout left_layout;
        LinearLayout right_layout;
    }

}

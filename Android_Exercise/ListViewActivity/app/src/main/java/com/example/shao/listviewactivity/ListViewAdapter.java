package com.example.shao.listviewactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by Shao on 2016/7/25.
 */
public class ListViewAdapter  extends BaseAdapter{
    public Context mContent;
    public LayoutInflater inflater;
    public List<Map<String,String>> mlist;
    private int resourceid;
    public ListViewAdapter(Context content,List<Map<String,String>> list,int ListviewresourceId) {
        mContent = content;
        mlist = list;
        inflater = LayoutInflater.from(content);
        resourceid = ListviewresourceId;
    }


    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i).get("title");
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v;
        ViewHolder viewHolder;
        if(convertView == null) {
            v = inflater.inflate(resourceid,null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) v.findViewById(R.id.title);
            viewHolder.context = (TextView) v.findViewById(R.id.content);
            viewHolder.imageView = (ImageView) v.findViewById(R.id.image1);
            v.setTag(viewHolder);
        }else {
            v = convertView;
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.title.setText(mlist.get(position).get(("title")));
        viewHolder.context.setText(mlist.get(position).get("context"));
        //viewHolder.imageView.setImageResource(news.getImageid());
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent,"Click Text",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent,"Image",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    class ViewHolder {
        TextView title;
        TextView context;
        ImageView imageView;
    }

    public void addItem (int position,Map<String, String> data)  {

        mlist.add(position,data);
    }

    public void updataItem(int position,Map<String, String> data) {


    }
}

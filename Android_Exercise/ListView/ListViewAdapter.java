package com.hxc.clouddoctor.clouddoctortochild.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxc.clouddoctor.clouddoctortochild.R;

import java.util.List;
import java.util.Map;

public class ListViewAdapter extends BaseAdapter {

	public Context mContext;
	public LayoutInflater inflater;
	public List<Map<String, String>> mList;

	public ListViewAdapter(Context context, List<Map<String, String>> list) {
		mContext = context;
		inflater = LayoutInflater.from(context);
		mList = list;
	}


	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup group) {

		convertView = inflater.inflate(R.layout.item_listview_1, null);
		ImageView iv = (ImageView) convertView.findViewById(R.id.iv_1);
		TextView title = (TextView) convertView.findViewById(R.id.tv_title);
		TextView content = (TextView) convertView.findViewById(R.id.tv_content);
		title.setText(mList.get(position).get("title"));
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		return convertView;
	}

}

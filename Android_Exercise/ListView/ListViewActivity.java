package com.hxc.clouddoctor.clouddoctortochild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hxc.clouddoctor.clouddoctortochild.adapter.ListViewAdapter;
import com.hxc.toolslibrary.commonutils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
	private ListView mListView;
	private ListViewAdapter mAdapter;
	private List<Map<String,String>> mapList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		initView();
	}

	private void initView(){
		mapList = new ArrayList<>();
		for (int i = 0;i < 10;i++){
			Map<String ,String > data = new HashMap<>();
			data.put("title","我是第几项：" + i);
			mapList.add(data);
		}
		mListView = (ListView) findViewById(R.id.listview);
		mAdapter = new ListViewAdapter(this,mapList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(onItemClickListener);

	}

	private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ToastUtils.showShort(ListViewActivity.this,"我是第几项：" + position);
		}
	};

}

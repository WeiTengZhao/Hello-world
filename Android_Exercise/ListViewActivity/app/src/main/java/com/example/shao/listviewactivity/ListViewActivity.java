package com.example.shao.listviewactivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity implements AbsListView.OnScrollListener {
    private ListView mlistView;
    private ListViewAdapter mAdapter;
    private List<Map<String, String>> mapList;
    private String[] str = {"AAA",
            "BBB","CCC","DDD","EEE",
            "FFF","GGG","HHH","III",
            "JJJ","KKK", "LLL","MMM",
            "NNN","OOO","PPP","QQQ","RRR",
            "TTT","SSS"};
    private int visibleItemCount;
    private int visibleLastIndex = 0;
    private View LoadMoreView;
    private Button Load_More_Button;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        LoadMoreView = getLayoutInflater().inflate(R.layout.load_more,null);
        Load_More_Button = (Button) LoadMoreView.findViewById(R.id.load_button);

        initView();

        mlistView.addFooterView(LoadMoreView);
        mlistView.setOnScrollListener(this);
    }

    public void initView() {
        mapList = new ArrayList<>(); //创建数据源
        for (int i = 0; i < 20; i++) {
            Map<String, String> data = new HashMap<>();
            if(i < str.length) {
                data.put("title", "title=" + i);
                data.put("context", "context=" + str[i]);
            }else {
                data.put("title", "title=" + i);
                data.put("context", "context=");
            }
            //data.put(String)("imageid",R.drawable.d1);
            mapList.add(data);
        }
        mAdapter = new ListViewAdapter(ListViewActivity.this, mapList, R.layout.item_listview_1);
        mlistView = (ListView) findViewById(R.id.listview);
        mlistView.setAdapter(mAdapter);//加载适配器
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                ListView listview = (ListView)parent;
                String str = (String)listview.getItemAtPosition(position);
                Toast.makeText(ListViewActivity.this,"Position:" + position,Toast.LENGTH_SHORT).show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(ListViewActivity.this);
                dialog.setTitle("你点击了" + str);
                dialog.setMessage("Position is:" + position);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int visibleItem = mlistView.getFirstVisiblePosition();
                        View v = mlistView.getChildAt(position - visibleItem);
                        TextView tv = (TextView) v.findViewById(R.id.content);
                        Map<String,String> d = new HashMap<>();
                        d.put("context","I Have been Click");
                        d.put("title","Click");
                        mapList.set(position,d);
                        mAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });


    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
            int visiblelastitem = mAdapter.getCount() - 1;
            int lastindex = visiblelastitem + 1 ;
            if (visibleLastIndex == lastindex && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                loadMore(mlistView);
            }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }

    public void loadMore(View view) {
        Load_More_Button.setText("Loading...");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loaddata();
                mAdapter.notifyDataSetChanged();

                mlistView.setSelection(visibleLastIndex - visibleItemCount + 1);
                Load_More_Button.setText("Load More");
            }
        },1000);

    }

    private void loaddata() {
        int count = mAdapter.getCount();
        if(count + 10 <= 40){
            for (int i = count; i < count + 10; i++) {
                Map<String, String> data = new HashMap<>();
                if(i < str.length) {
                    data.put("title", "title=" + i);
                    data.put("context", "context=" + str[i]);
                }else {
                    data.put("title", "title=" + i);
                    data.put("context", "context=");
                }
            //data.put(String)("imageid",R.drawable.d1);
            mAdapter.addItem(i,data);
            }
        }else {
            for (int i = count ; i < 41 ; i ++) {
                Map<String, String> data = new HashMap<>();
                data.put("title", "title=" + i);
                data.put("context", "context=" + count);
                mAdapter.addItem(i,data);
            }
        }

//        for (int i = 0; i < 10; i++) {
//            Map<String, String> data = new HashMap<>();
//            if(i < str.length) {
//                data.put("title", "title=" + i);
//                data.put("context", "context=" + str[i]);
//            }else {
//                data.put("title", "title=" + i);
//                data.put("context", "context=");
//            }
//            mapList.add(data);
//        }

       // mAdapter.notifyDataSetChanged();
    }

}


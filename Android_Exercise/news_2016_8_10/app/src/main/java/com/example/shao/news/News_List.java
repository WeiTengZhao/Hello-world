package com.example.shao.news;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class News_List extends AppCompatActivity implements AbsListView.OnScrollListener {
    private ListView mlistView1;
    private ListAdapter madapter;
    private PagerAdapter mpagerAdapter;
    private ViewPager viewPager;
    private int visibleItemCount;//可视的Item数目
    private int visibleLastIndex = 0;//最后可视索引
    private View image_item;
    private View v1;//ViewPager第一个页面
    private View v2;//ViewPager第二个页面
    private View LoadMoreView;//底部载入进度条
    private Handler handler1 = new Handler();//Handler对象，用于定义多线程操作
    private ProgressBar progressBar;
    private List<View> viewList;
    private List<Map<String,String>> mapList;
    RefreshableView refreshableView;
    private New aNew;
    private List<New> list;

    String url = "http://school.wojia99.com/public/index.php?d=android&c=news&m=list4&catid=4";//设置URL地址从网上获取数据
//设置异步消息处理机制，使得子线程得以对UI进行操作

    private String[] str = {"新闻内容1","新闻内容2","新闻内容3","新闻内容4","新闻内容5","新闻内容6","新闻内容7",
            "新闻内容8","新闻内容9","新闻内容10","新闻内容11","新闻内容12","新闻内容13","新闻内容14","新闻内容15","新闻内容16",
            "新闻内容17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__list);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);显示ActionBar的箭头
        actionBar.setDisplayUseLogoEnabled(true);//显示图标
        actionBar.setIcon(R.mipmap.icon);//设置ActionBar图标

        list = new ArrayList<New>();//初始化list

        //网络访问
        HttpUtil.sendHttpRequest(url, new HttpCallBackListener() {
            @Override
            public void onFinish(String response) {
                parseJSONWithGSON(response);
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                Log.d("is","44444444444441");
            }
        });

        //弹出测试DEMO说明框
        AlertDialog.Builder builder = new AlertDialog.Builder(News_List.this);
        builder.setTitle("说明");
        builder.setMessage("ListView 的item比较多，故只在前面几个item设置了的点击事件监听及跳转至新闻详情页的响应");
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            //网络访问
                    HttpUtil.sendHttpRequest(url, new HttpCallBackListener() {
                        @Override
                        public void onFinish(String response) {
                            parseJSONWithGSON(response);
                        }

                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                            Log.d("is","44444444444441");
                        }
                    });

            }
        });
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

        //设置下拉刷新
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        },0);


        //设置底部载入栏
        LoadMoreView = getLayoutInflater().inflate(R.layout.load_more,null);
        progressBar = (ProgressBar) LoadMoreView.findViewById(R.id.progressbar);
        //ViewPager载入布局
        v1 = getLayoutInflater().inflate(R.layout.layout1,null);
        v2 = getLayoutInflater().inflate(R.layout.layout2,null);//获取布局
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        //获取ListView的适配器Adapter
        madapter = new ListAdapter(News_List.this,list,R.layout.list_item);//调用构造方法初始化Adapter

        mlistView1 = (ListView) findViewById(R.id.list1_item);
        mlistView1.setAdapter(madapter);//加载适配器
        mlistView1.setOnItemClickListener(new AdapterView.OnItemClickListener() { //点击事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) { //根据点击不同的item,跳转不同的内容
                    case 0 :
                        Intent intent = new Intent(News_List.this,news_content.class);
                        startActivity(intent);
                    case 1 :
                        Intent intent1 = new Intent(News_List.this,news_content.class);
                        startActivity(intent1);
                    case 2 :
                        Intent intent2 = new Intent(News_List.this,news_content.class);
                        startActivity(intent2);
                    case 3 :
                        Intent intent3 = new Intent(News_List.this,news_content.class);
                        startActivity(intent3);
                }
            }
        });

        mlistView1.addFooterView(LoadMoreView);//增加下滑时底部显示的ProgressBar
        mlistView1.setOnScrollListener(this);//设置下滑监听器

        final TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();//启动并添加TAB
        tabhost.addTab(tabhost.newTabSpec("t1").setIndicator(changeTabWight("新闻",R.mipmap.ic_launcher)).setContent(R.id.tab01));
        tabhost.addTab(tabhost.newTabSpec("t2").setIndicator(changeTabWight("图片",R.mipmap.ic_launcher)).setContent(R.id.tab02));
        tabhost.addTab(tabhost.newTabSpec("t3").setIndicator(changeTabWight("视频",R.mipmap.ic_launcher)).setContent(R.id.tab03));
        tabhost.addTab(tabhost.newTabSpec("t4").setIndicator(changeTabWight("更多",R.mipmap.ic_launcher)).setContent(R.id.tab04));
        initcolor(tabhost);//初始化Tab背景色
         }

    private void parseJSONWithGSON(String response) { //使用Gson解析JSON
        Gson gson = new Gson();
        List<New> newlist = gson.fromJson(response,new TypeToken<List<New>>(){}.getType());
        for (int i = 0 ; i < newlist.size(); i++) {
            aNew = newlist.get(i);
            Log.d("GSON","id is :" + aNew.getId());
            Log.d("GSON","AddTime is :" + aNew.getAddtime());
            Log.d("GSON","Title is :" + aNew.getTitle());
            Log.d("GSON","Thumb is :" + aNew.getThumb());
            Bitmap bitmap = null;
            try {
                bitmap = ToBitmap.toBitmap(aNew.getThumb());
            }catch (Exception e) {
                e.printStackTrace();
            }
                aNew.setBitmap(bitmap);
            runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  mlistView1.setAdapter(madapter); //返回主线程重设Adapter
                              }
                          }
            );
//            try {
//                URL url = new URL(aNew.getThumb().toString());
//                HttpUtil.onloadImage(url, new OnLoadImageListener() {
//                @Override
//                public void OnLoadImage(Bitmap obj, String BitmapPath) {
//                    if (obj != null) {
//                        aNew.setBitmap(obj);
//                    }else {
//                        Log.d("viewHolder error:","Can't get Bibmap!");
//                    }
//                }
//            });
//            }catch (Exception e) {
//                e.printStackTrace();
//                Log.d("GSON","URL Exception");
//            }
            list.add(aNew);
        }
    }
    public void initView(String[] str,Integer [] iv) {
        mapList = new ArrayList<>();//获取数据源的内容
        int j = 0;
        for(int i = 0; i < 21 ; i ++) { //第一次打开显示的条目数
            Map<String ,String> data = new HashMap<>();
            if (i < str.length) {
                data.put("title","Title:" + i);
                data.put("context",str[i]);
//                if (j < iv.length - 1) {
//                    data.put("image", iv[i].toString());
//                    j++;
//                }
                data.put("image",String.valueOf(R.mipmap.icon));
            }else {
                data.put("image", String.valueOf((R.mipmap.icon)));
                data.put("title","Title:" + i);
                data.put("context","AAA");
            }
            mapList.add(data);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int visiblelastitem = madapter.getCount() - 1;
        int lastindex = visiblelastitem + 1;
        if (lastindex == visibleLastIndex && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            //滑动到最底部，调用loadmore()读取更多item
        }
    }
     @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }

    //TabWight添加图片的方法
    private View changeTabWight (String s,int i) {
        LinearLayout layout = new LinearLayout(this);
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);

        ImageView iv = new ImageView(this);
        iv.setImageResource(i);
        layout.addView(iv, LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText(s);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(tv,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        return layout;
    }

    private void updatecolor(TabHost tabHost) {//设置点击时Tab颜色变化
        for(int i = 0; i < tabHost.getTabWidget().getChildCount();i ++) {
           if(i == tabHost.getCurrentTab()) {
               tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.GRAY);
           }else {
               tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
           }
        }
    }

    private void initcolor(TabHost tabHost) {  //初始化tab的颜色
        for(int i = 0; i < tabHost.getTabWidget().getChildCount();i ++) {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
        }
        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.GRAY);//默认选中第一个，故颜色设为选中色
    }




//之前未使用ListView部分的代码
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            finish();
//        }else {return true;}
//        return super.onKeyDown(keyCode, event);
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {//监听ActionBar箭头，按下回退
//        if(item.getItemId() == android.R.id.home) {
//            onBackPressed();
//            return (true);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void change2(View view) {
//        Intent intent2 = new Intent(this,news_content.class);
//        startActivity(intent2);
//
//    }
}

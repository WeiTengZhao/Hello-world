package com.example.shao.tabhost2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        final TabWidget tabWidget = tabHost.getTabWidget();
        final TabHost.TabSpec t1 = tabHost.newTabSpec("t1");
        t1.setIndicator(composeLayout("标签1",R.mipmap.ic_launcher));
        t1.setContent(R.id.tab001);
        tabHost.addTab(t1);
        tabHost.addTab(tabHost.newTabSpec("t2").setContent(R.id.tab002).setIndicator(composeLayout("Tab2",R.mipmap.ic_launcher)));
        tabHost.addTab(tabHost.newTabSpec("t3").setContent(R.id.tab003).setIndicator(composeLayout("TAB3",R.mipmap.ic_launcher)));
        inicolor(tabHost);
        tabHost.setCurrentTab(1);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                updatacolor(tabHost);
                if (tabId.equals("t1")) {
                    Toast.makeText(MainActivity.this,"Tab1 Click",Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("t2")) {
                    Toast.makeText(MainActivity.this,"Tab2 Click",Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("t3")) {
                    Toast.makeText(MainActivity.this,"Tab3 Click",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private View composeLayout(String s,int i) { //String是标题，i是加载图片的id
        LinearLayout layout = new LinearLayout(this);//定义LinearLayout对象
        layout.setOrientation(LinearLayout.VERTICAL);//设置layout布局属性
        layout.setGravity(Gravity.CENTER);
        //向定义的layout中添加子view
        ImageView iv = new ImageView(this); //创建ImageView对象
        iv.setImageResource(i);             //设置图像
        layout.addView(iv,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));                 //添加到layout中

        TextView tv = new TextView(this);   //创建TextView对象，用作Tab标题
        tv.setText(s);                      //设置文本内容
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(tv,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        return  layout;
    }

    private void updatacolor(TabHost tabHost) {
        for(int i = 0 ; i < tabHost.getTabWidget().getChildCount() ; i ++) {
            if(i == tabHost.getCurrentTab()) {
                tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.GRAY);
            }else {
                tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
            }
        }
    }

    private void inicolor(TabHost tabHost) {
        for(int i = 1 ; i < tabHost.getTabWidget().getChildCount();i ++) {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
        }
        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.GRAY);
    }
}

package com.example.shao.testtabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity  extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();//定义TabHost对象
        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);
        final TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");//新建标签页1
        tab1.setIndicator("标签页1");//设置标题
        tab1.setContent(R.id.tab001);//设置标签页内容
        tabHost.addTab(tab1);//添加标签页1

        final TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");//新建标签页1
        tab2.setIndicator("标签页2");//设置标题
        tab2.setContent(R.id.tab002);//设置标签页内容
        tabHost.addTab(tab2);//添加标签页2

        final TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");//新建标签页1
        tab3.setIndicator("标签页3");//设置标题
        tab3.setContent(R.id.tab003);//设置标签页内容
        tabHost.addTab(tab3);//添加标签页3

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("tab1")) {
                    Toast.makeText(MainActivity.this,"标签页1被点击",Toast.LENGTH_SHORT).show();
                }
                if (s.equals("tab2")) {
                    Toast.makeText(MainActivity.this,"标签页2被点击",Toast.LENGTH_SHORT).show();
                }
                if(s.equals("tab3")) {
                    Toast.makeText(MainActivity.this,"标签页3被点击",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

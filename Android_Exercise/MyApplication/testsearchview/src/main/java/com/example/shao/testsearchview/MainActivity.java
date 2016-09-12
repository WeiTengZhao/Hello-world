package com.example.shao.testsearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle("hahaha");//设置ToolBar标题
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置Toolbar向上返回的图标
        setSupportActionBar(toolbar);//使活动支持ToolBar
    }
}

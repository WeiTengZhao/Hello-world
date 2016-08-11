package com.example.shao.news;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class news_content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);//显示ActionBar的箭头
        actionBar.setDisplayUseLogoEnabled(true);//显示图标
        actionBar.setIcon(R.mipmap.icon);//设置ActionBar图标
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//监听ActionBar箭头，按下回退
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }


}

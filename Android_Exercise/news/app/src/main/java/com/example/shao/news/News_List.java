package com.example.shao.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

public class News_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);//显示ActionBar的箭头
        actionBar.setDisplayUseLogoEnabled(true);//显示图标
        actionBar.setIcon(R.mipmap.icon);//设置ActionBar图标
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }else {return true;}
        return super.onKeyDown(keyCode, event);
    }

    public boolean onOptionsItemSelected(MenuItem item) {//监听ActionBar箭头，按下回退
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    public void change2(View view) {
        Intent intent2 = new Intent(this,news_content.class);
        startActivity(intent2);

    }
}

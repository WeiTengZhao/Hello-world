package com.example.shao.news;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉顶部状态栏
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(r,3000); //欢迎页自动跳转
    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this,News_List.class);
            startActivity(intent);
            finish();
        }
    };
    /*public void change(View view) {
        Intent intent = new Intent(this,News_List.class);
        startActivity(intent);
        finish();
    }*/

}

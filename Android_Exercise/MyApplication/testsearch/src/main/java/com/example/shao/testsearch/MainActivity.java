package com.example.shao.testsearch;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearchRequested(); //通过此方法，显示一个Search Dialog
                Toast.makeText(MainActivity.this,"Clickkkkkkkkkkkkk",Toast.LENGTH_SHORT).show();
            }
        });
    }
/**
@ Description : 使用SingleTop启动模式时，不开新页面刷新Intent
**/
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handIntent(intent);
    }

    private void handIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String equry = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(equry);
        }
    }

    private void doMySearch(String equry) {
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(equry);
        Toast.makeText(MainActivity.this,"搜索执行",Toast.LENGTH_SHORT).show();
    }
}



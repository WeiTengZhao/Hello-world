package com.example.shao.brocastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBrocast();
            }
        });

    }

    private void sendBrocast() {  // 发送广播
        Intent intent = new Intent("com.example.brocastbestpractice.FORCE.OFFLINE");
        sendBroadcast(intent);
    }
}

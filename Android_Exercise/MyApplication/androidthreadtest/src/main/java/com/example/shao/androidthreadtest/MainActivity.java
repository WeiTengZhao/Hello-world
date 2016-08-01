package com.example.shao.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private static final int CHANGE_FLAG = 1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_FLAG:
                    textView.setText("Nice to meet YOU!");
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.change_text);
        textView = (TextView)findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread mythread = new MyThread();
                new Thread (mythread).start();
            }
        });
    }
    class MyThread implements Runnable {
        @Override
        public void run() {
            Message message = new Message();
            message.what = CHANGE_FLAG;
            handler.sendMessage(message);
        }
    }
}

package com.example.shao.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button start_Service;
    private Button end_Service;
    private Button bind;
    private Button unbind;
    private Button intentservice;
    private Button close_intentservice;
    private MyService.DownloadBinder downloadBinder;    //获取downloadBinder对象

    private ServiceConnection connetion = new ServiceConnection() { //创建匿名类，获取DownloadBinder实例
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_Service = (Button) findViewById(R.id.start_service);
        end_Service = (Button) findViewById(R.id.end_service);
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        intentservice = (Button) findViewById(R.id.intentservice);
        close_intentservice = (Button) findViewById(R.id.closeintentservice);


        start_Service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this,MyService.class);
                startService(startIntent);
                Toast.makeText(MainActivity.this,"Sheee",Toast.LENGTH_SHORT).show();
            }
        });

        end_Service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent endIntent = new Intent(MainActivity.this,MyService.class);
                stopService(endIntent);
            }
        });

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bind = new Intent(MainActivity.this,MyService.class); //通过Intent对象绑定Service
                bindService(bind,connetion,BIND_AUTO_CREATE); //三个参数：Intent对象，downloadbinder实例，绑定后自动创建服务标志位
            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connetion); //解除绑定，通过downloadbinder对象进行设置
            }
        });

        intentservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentservice = new Intent(MainActivity.this,MyIntentService.class);
                startService(intentservice);
                Log.d("MainActivity","Thread ID is" + Thread.currentThread().getId());
            }
        });

        close_intentservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent close = new Intent(MainActivity.this,MyIntentService.class);
                stopService(close);
            }
        });

    }
}

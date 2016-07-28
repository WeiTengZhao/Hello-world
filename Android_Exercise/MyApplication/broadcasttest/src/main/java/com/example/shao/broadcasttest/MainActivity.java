package com.example.shao.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();                              //创建IntentFiltershil实例
        networkChangeReceiver = new NetworkChangeReceiver();            //创建NetworkChangeReceiver实例
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); //添加Action，想接收什么样的广播就添加什么Action
        registerReceiver(networkChangeReceiver,intentFilter);           //注册两个实例

        Button button = (Button) findViewById(R.id.sendbroad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);                      //当Activity运行结束后，解除实例的注册
    }

    class NetworkChangeReceiver extends BroadcastReceiver {             //写内部类，继承自BriadcastReceiver，重写onReceiver（）实现监听

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//获取系统服务类实例
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();//在专门管理网络连接的系统服务类中获取实例
            if(networkInfo != null && networkInfo.isAvailable()) {//判断网络状态是否可用
                Toast.makeText(MainActivity.this,"网络可用",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,"网络不可用",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

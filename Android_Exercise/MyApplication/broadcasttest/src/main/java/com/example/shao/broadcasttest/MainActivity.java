package com.example.shao.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();                              //创建IntentFiltershil实例
        networkChangeReceiver = new NetworkChangeReceiver();            //创建NetworkChangeReceiver实例
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); //添加Action，想接收什么样的广播就添加什么Action
        registerReceiver(networkChangeReceiver,intentFilter);           //注册两个实例

        localBroadcastManager = LocalBroadcastManager.getInstance(this); //获取LocalBroadcastManager实例

        Button button = (Button) findViewById(R.id.sendbroad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROCASTTEDT");
                localBroadcastManager.sendBroadcast(intent);            //使用LocalBroadcastManager对象发送广播
            }
        });
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROCASTTEDT");//添加本地action
        localReceiver = new LocalReceiver();                            //获取接收器实例
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);//使用LocalBroadcastManager注册
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);                      //当Activity运行结束后，解除实例的注册
        localBroadcastManager.unregisterReceiver(localReceiver);        //使用LocalBroadcastManager对象解除注册
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
    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"收到内部广播",Toast.LENGTH_SHORT).show();
        }
    }
}

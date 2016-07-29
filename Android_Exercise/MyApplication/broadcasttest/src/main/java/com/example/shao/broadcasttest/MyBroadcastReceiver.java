package com.example.shao.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Shao on 2016/7/28.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"收到了广播com.example.broadcasttest",Toast.LENGTH_LONG).show();
        //abortBroadcast();
    }
}

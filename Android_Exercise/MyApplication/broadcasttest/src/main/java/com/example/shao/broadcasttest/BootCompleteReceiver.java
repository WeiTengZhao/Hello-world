package com.example.shao.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Shao on 2016/7/28.
 */
public class BootCompleteReceiver extends BroadcastReceiver{    //静态注册广播写外部类实现

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"开机成功",Toast.LENGTH_LONG).show();
    }
}

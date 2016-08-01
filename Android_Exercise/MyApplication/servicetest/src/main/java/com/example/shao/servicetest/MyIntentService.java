package com.example.shao.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Shao on 2016/8/1.
 */
public class MyIntentService extends IntentService{
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onDestroy() {
        Log.d("MyIntentService","Destroy");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService","Thread is:" + Thread.currentThread().getId());
    }
}

package com.example.shao.servicebestpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by Shao on 2016/8/1.
 */
public class LongRunningService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myThread mythread = new myThread();
        new Thread (mythread).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(LongRunningService.this,AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(LongRunningService.this,0,i,0);
        long minte = SystemClock.elapsedRealtime() + 60 * 1000;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,minte,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class myThread extends Thread {
        @Override
        public void run() {
            Log.d("LongRunningService","Execute:" + new Date().toString());
        }
    }
}

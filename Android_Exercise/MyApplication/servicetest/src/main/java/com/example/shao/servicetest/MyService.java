package com.example.shao.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Shao on 2016/8/1.
 */
public class MyService extends Service {
    private DownloadBinder downloadBinder = new DownloadBinder();//获取新建绑定类的实例

    public class DownloadBinder extends Binder { //新建继承自Binder的类的对象，要指定Service执行的内容写在这里面
        public void startDownload() {
            Log.d("DownloadBinder","startDownload");
        }
        public int getProgress() {
            Log.d("DownloadBinder","getProgress");
            return 0;
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("onStartCommand","StartCommand!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("onDestroy","Destroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { //将绑定类实例返回，进行绑定
        return downloadBinder;
    }

    @Override
    public void onCreate() {
        //创建通知
        Notification notification = new Notification(R.mipmap.ic_launcher,"Notification is coming",System.currentTimeMillis());
        Intent notifiIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this,0, new Intent[]{notifiIntent},0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Title");//setLatestEvenInfo方法已被弃用，使用新Builder代替
        builder.setContentText("Content");
        notification = builder.getNotification();
        startForeground(1,notification);//使当前Service变成前台Service在通知栏显示

        Log.d("onCreate","Create!");
        super.onCreate();
    }
}

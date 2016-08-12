package com.example.shao.news;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by Shao on 2016/8/11.
 */
public class MyApplication extends Application {
    private static Application intance;

    public static Application getIntance() {
        return intance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
        NoHttp.initialize(this);
        Logger.setDebug(true);
        Logger.setTag("news");
    }
}

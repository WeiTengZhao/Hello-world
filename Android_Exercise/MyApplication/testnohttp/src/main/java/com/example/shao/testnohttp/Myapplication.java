package com.example.shao.testnohttp;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by Shao on 2016/8/9.
 */
//系统的Application的继承
public class Myapplication extends Application { //新建一个Application用于初始化NoHttp
    private static  Application intance;

    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
        //初始化NoHttp
        NoHttp.init(this);
        //打开NoHttp的调试模式
        Logger.setDebug(false);
        //设置日志的Tag，变量为项目名
        Logger.setTag("TestNoHttp");
    }
//得到应用程序的application
    public static Application getInstance() {
        return intance;
    }


}

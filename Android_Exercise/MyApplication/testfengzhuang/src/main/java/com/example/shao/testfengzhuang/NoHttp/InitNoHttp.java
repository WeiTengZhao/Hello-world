package com.example.shao.testfengzhuang.NoHttp;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;


/**
@ Description:初始化NoHttp
**/
public class InitNoHttp extends Application {
    private static Application intance; //设置静态的Application 类型变量intance,用来接收应用程序的Application

    public static Application getIntance() { //静态变量intance的get方法
        return intance;
    }

    @Override                //重写Application的onCreate()方法
    public void onCreate() {
        super.onCreate();
        intance = this;//初始化intance
        NoHttp.initialize(this);//初始化NoHttp,键97点补充
        Logger.setDebug(true);//设置调试模式
        Logger.setTag("TestFengZhuang");//打开日志

    }
}

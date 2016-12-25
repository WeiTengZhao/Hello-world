package com.example.shao.testfengzhuang.NoHttp;

import android.content.Context;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

/**
@ Description:用于请求服务器的类
**/
public class CallServer {
    private static CallServer instance;
    private RequestQueue requestQueue;

    public synchronized static CallServer getInstance() {
        if (instance == null) {
            instance = new CallServer();
        }
        return instance;
    }

    //为了防止web多次new所以写一个空构造方法，使其只能内部访问
    public CallServer() {
        requestQueue = NoHttp.newRequestQueue();//保证只生成一个队列
    }
/**
@ Description :add()添加一个请求到请求队列
@ context:上下文
@ request:请求对象
@ callBack:接受回调结果
 @ what:并发请求时用来区分请求
 @ isShowError:是否显示错误
 @ isCancancle:请求是否能被用户取消
 @ isShowDialog:是否显示请求Dialog
**/
    public <T> void add (Context context, final Request<T> request, HttpCallBack callBack,int what,boolean isShowDialog, boolean isCancancle, boolean isShowError) {
        requestQueue.add(what,request,new ResponseListener<T> (context,request,callBack,isShowDialog,isCancancle,isShowError));
    }
}

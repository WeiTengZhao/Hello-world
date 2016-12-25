package com.example.shao.testfengzhuang.NoHttp;


import com.yolanda.nohttp.rest.Response;

/**
@ Description:OnSuccess 和 OnFailed 方法的回调接口
**/
public interface HttpCallBack<T> {

    void onSucceed(int what, Response<T> response);

    void onFailed(int what, Response<T> response);
}

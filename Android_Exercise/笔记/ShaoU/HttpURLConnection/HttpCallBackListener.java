package com.example.shao.news;

/**
 * Created by Shao on 2016/8/10.
 */
public interface HttpCallBackListener {
    void onFinish(String response);

    void onError(Exception e);
}

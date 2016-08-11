package com.example.shao.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Shao on 2016/8/10.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address,final HttpCallBackListener listener) {
        new Thread (new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    URL url = new URL(address);//设置URL地址,获取URL对象
                    httpURLConnection = (HttpURLConnection) url.openConnection();//通过URL对象获取HttpURLConnection对象
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("GET");
                    int code = httpURLConnection.getResponseCode();
                    if (code == 200) {
                        InputStream is = httpURLConnection.getInputStream();
                        String response = CoverStreamToString(is);//调用输入流处理函数
                        if (listener != null) {
                            listener.onFinish(response);
                        }
                    }

                }catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                        Log.d("is","1111111111111111111");
                    }
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).start();

    }

    private static String CoverStreamToString(InputStream is) { //输入流处理函数
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder builder = new StringBuilder();
        try {
            while (( line = reader.readLine() )!= null) {
                builder.append(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
            Log.d("is","22222222222222222222");
        }finally {
            try {
                is.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    //URL获取图片
    public static void onloadImage (final URL BitmapURL, final OnLoadImageListener onLoadImageListener) {
       //定义异步处理机制
        Looper.prepare();
        final Handler handler = new Handler() {
            public void handlerMessage(Message msg) {
                onLoadImageListener.OnLoadImage((Bitmap)msg.obj,null);
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageURL = BitmapURL;//获取URL
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageURL.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    InputStream in = conn.getInputStream();//构建出HttpConnection对象取得输入流
                    Bitmap bitmap = BitmapFactory.decodeStream(in);//构建bitmap
                    Message message = new Message();
                    message.obj = bitmap;
                    handler.sendMessage(message);
                }catch (Exception e) {
                    e.printStackTrace();
                    Log.d("onLoadImage-run:","Exception");
                }
            }
        }).start();
    }
}

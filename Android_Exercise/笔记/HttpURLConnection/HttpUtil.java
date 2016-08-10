package com.example.shao.news;

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
                    httpURLConnection.setRequestMethod("GET");

                    InputStream is = httpURLConnection.getInputStream();

                    String response = CoverStreamToString(is);//调用输入流处理函数
                    if (listener != null) {
                        listener.onFinish(response);
                    }
                }catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
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
        StringBuilder builder = null;
        try {
            builder = new StringBuilder();
            while (( line = reader.readLine() )!= null) {
                builder.append(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}

package com.example.shao.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ToBitmap {
    public static Bitmap toBitmap(String path)throws  Exception{
        Bitmap bitmap = null;
                URL url = new URL(path);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");	//此参数要求大写
                urlConnection.setConnectTimeout(5000);
                int code = urlConnection.getResponseCode();	//当code==200表示访问服务器成功
                if(code == 200) {
                    //7.获取服务器的返回数据（数据以流的形式返回）
                    InputStream in = urlConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(in);

                }
        return bitmap;
    }
}

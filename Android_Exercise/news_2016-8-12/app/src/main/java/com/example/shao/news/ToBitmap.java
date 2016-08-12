package com.example.shao.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ToBitmap {
    public static Bitmap toBitmap(String path) {
        Bitmap bitmap = null;
        try {
            Log.d("ToBitMap","Path" +" "+ path );
            URL url = new URL(path);
            Log.d("ToBitMap","url" +" "+ url );
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            Log.d("ToBitMap222222222222","url" +" "+ url );
            urlConnection.setRequestMethod("GET");    //此参数要求大写
            urlConnection.setConnectTimeout(10000);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            int code = urlConnection.getResponseCode();    //当code==200表示访问服务器成功
            Log.d("ToBitMap","URL" + url + "C" + code);
            if (code == 200) {
                //7.获取服务器的返回数据（数据以流的形式返回）
                InputStream in = urlConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(in);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
            Log.d("ToBitmap","GETTTTTTTTTTTTTTTTTTTTT");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.d("ToBitMap","URL" + path);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ToBitMap","IOIOIOIOIOOIOOO");
        }
        return bitmap;
    }
}

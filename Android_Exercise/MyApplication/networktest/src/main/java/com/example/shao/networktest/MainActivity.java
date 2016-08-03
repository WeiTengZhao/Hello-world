package com.example.shao.networktest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button send_request;
    private TextView response;
    private static final int SHOW_RESPONSE = 0;
    private Handler handler = new Handler() {

        public void handleMessage(Message msg) { //定义Message对象进行UI操作
            switch (msg.what) {
                case SHOW_RESPONSE:
                    String responseable = (String) msg.obj;
                    response.setText(responseable);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        send_request = (Button) findViewById(R.id.send_request);
        response = (TextView) findViewById(R.id.respsonse);//获取view对象
        
        send_request.setOnClickListener(this); //设置点击事件监听
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_request :
                sendRequestWithUrlConnection();
                Toast.makeText(MainActivity.this,"Button",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

    private void sendRequestWithUrlConnection() {
        MyThread mythread = new MyThread();//建立新的子线程
        mythread.start();
    }

    private class MyThread extends Thread  {

        @Override
        public void run() {
            HttpURLConnection httpurlconnection = null;
            try {
                URL url = new URL("http://www.baidu.com");
                httpurlconnection = (HttpURLConnection) url.openConnection();//通过url对象获取HttpURLConnection对象
                //对HttpURLConnection对象进行基本设置
                httpurlconnection.setConnectTimeout(8000);//连接超时时间
                httpurlconnection.setReadTimeout(8000);//读取超时时间
                httpurlconnection.setRequestMethod("GET");//请求方法
                //获取流对象进行流操作
                InputStream in = httpurlconnection.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = read.readLine() ) != null) {
                    builder.append(line);
                }

                Message message = new Message();//定义UI操作的Messages实例
                message.what = SHOW_RESPONSE; //定义的Message实例标志，便于接受区分开做不同处理
                message.obj = builder.toString(); //向Message发送的数据内容
                handler.sendMessage(message); //向Message发送实例

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(httpurlconnection != null) { //判断结束时HttpURLConnection是否还有，有则关闭连接
                    httpurlconnection.disconnect();
                }
            }

        }
    }
}

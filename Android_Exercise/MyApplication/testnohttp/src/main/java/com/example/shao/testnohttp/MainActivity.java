package com.example.shao.testnohttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity {
    private int WHAT = 0;//设置请求特征码
    private RequestQueue mRequeset;//设置新的请求队列
    private String url = "http://school.wojia99.com/public/index.php?d=android&c=news&m=list4&catid=4";
    private Button button;
    private TextView tv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequeset = NoHttp.newRequestQueue(1);//生成一个请求队列，可以传入整形数定义同时并发请求数，默认为3

        button = (Button) findViewById(R.id.send);
        tv = (TextView) findViewById(R.id.context);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reques();//点击时调用向服务发起请求方法
            }
        });
    }

    private void reques() { //设置请求方法,请求服务器
        Request<String> request = NoHttp.createStringRequest(url);
        request.add("id","");//传入参数
        request.add("version","");
        request.add("name","");

        mRequeset.add(WHAT,request,listener);//将接口传入请求队列,3个参数 特征码，请求接口，返回监听
    }
    private OnResponseListener<String> listener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {
                Toast.makeText(MainActivity.this,"开始向服务器请求数据",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            Headers header = response.getHeaders();

                tv.setText(response.get());
        }

        @Override
        public void onFailed(int what, Response<String> response) {

        }



        @Override
        public void onFinish(int what) {

        }
    };



}

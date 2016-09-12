package com.example.shao.testfengzhuang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shao.testfengzhuang.NoHttp.CallServer;
import com.example.shao.testfengzhuang.NoHttp.HttpCallBack;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int WHAT = 0;//定义一个并发区分的特征码
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.text_1);
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Request<String> request = NoHttp.createStringRequest("https://www.baidu.com/", RequestMethod.GET);//创建请求
//        request.add("wa","wa");//添加参数
        CallServer.getInstance().add(this,request,callBack,WHAT,true,false,false);
    }
    private HttpCallBack<String> callBack = new HttpCallBack<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            tv.setText(response.get());
        }

        @Override
        public void onFailed(int what, Response<String> response) {

        }
    };
}

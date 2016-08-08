package com.example.shao.networktest_httpclient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class MainActivity extends Activity {
    private TextView textView;
    private Button button;
    private static final int SHOW_RESPONSE = 0;
    private Handler handler = new Handler() {//使用Message对象进行异步消息处理
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_RESPONSE :
                    String response = (String)msg.obj;
                    textView.setText(response);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.response);//获取View对象
        button = (Button) findViewById(R.id.send_request);

        button.setOnClickListener(new View.OnClickListener() { //设置点击监听
            @Override
            public void onClick(View view) {
               sendRequestWithHttpClient();
                Toast.makeText(MainActivity.this,"Button Click",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendRequestWithHttpClient() {
       myThread mythread = new myThread();
        mythread.start();

    }

    private class myThread extends Thread {
        @Override
        public void run() {
            try {
                HttpClient httpClient = new DefaultHttpClient(); //通过DefaultClient创建实例HttpClient
                HttpGet httpGet = new HttpGet("http://192.168.56.1:8080/get_data.json");//创建HttpGet对象
                HttpResponse httpResponse = httpClient.execute(httpGet);//获取Response对象包含响应的返回信息
                if (httpResponse.getStatusLine().getStatusCode() == 200 ) { //判断是否得到响应
                    HttpEntity entity = httpResponse.getEntity();//通过entity获取字符串
                    String response = EntityUtils.toString(entity,"utf-8");
                    /*对xml进行PUll解析
                    parseXMLwithPull(response);*/
                    /*使用JSONObject对JOSN进行解析
                    parseJOSNWithJSONObject(response);
                    */
                    /*使用GSON对JSON进行解析*/
                    parseJSONWithGSON(response);
                    //将字符串发给Message进行异步处理
                    Message message = new Message();
                    message.what = SHOW_RESPONSE;
                    message.obj = response.toString();
                    handler.sendMessage(message);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJSONWithGSON(String response) {//使用GSON解析JSON
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(response, new TypeToken<List<App>>(){}.getType()); //JSON数组通过TypeToken对象传入gson.fronJson方法中，通过Json方法，我们可以将JSON数据直接转成类App的对象
        for (App app:appList) {
            Log.d("GSON","id is :" + app.getId());
            Log.d("GSON","name is :" + app.getName());
            Log.d("GSON","Version is :" + app.getVersion());
        }
    }

    private void parseJOSNWithJSONObject(String jsonData) {
        try{
            JSONArray jsonArray = new JSONArray(jsonData);//将Response对象传进来，构建JSONArray对象
            for(int i = 0 ;i < jsonArray.length(); i++) { //遍历JSONArray对象，获取JSONObject对象
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");// 使用JSONObject对象对JSON进行解析
                String version = jsonObject.getString("version");
                String name = jsonObject.getString("name");

                Log.d("JSON","id is:"+ id);
                Log.d("JSON","name is:"+ name);
                Log.d("JSON","version is:" + version);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLwithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//获取XmlPullParserFactory实例
            XmlPullParser pullparser = factory.newPullParser();//由XmlPullParserFactory实例获得XmlPullParser对象
            pullparser.setInput(new StringReader(xmlData));  //将返回的内容xmlData设置到XmlPullParser对象中去
            int evenType = pullparser.getEventType();       //获取参数类型进行解析

            //定义存放数据的参数
            String name = "";
            String id = "";
            String version = "";

            //开始进行解析
            while (evenType != XmlPullParser.END_DOCUMENT) { //说明解析没有结束
                String nodeName = pullparser.getName();//获取当前节点的名字
                switch (evenType) {
                    case XmlPullParser.START_TAG : //开始解析某个节点
                        if (nodeName.equals("id")) { //节点名等于id、version、name就使用nextText()方法获取内容
                            id = pullparser.nextText();
                        }
                        if (nodeName.equals("name")) {
                            name = pullparser.nextText();
                        }
                        if (nodeName.equals("version")) {
                            version = pullparser.nextText();
                        }
                        break;

                    case XmlPullParser.END_TAG : //结束解析某个节点
                        if(nodeName.equals("app")) {
                            Log.d("PULL",id);
                            Log.d("PULL",version);
                            Log.d("PULL",name);
                        }
                        break;
                    default:
                        break;
                }
                evenType = pullparser.next();//获取下一个解析事件
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

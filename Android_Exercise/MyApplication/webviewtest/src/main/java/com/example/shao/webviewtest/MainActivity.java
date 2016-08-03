package com.example.shao.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading (WebView view,String url) {
               view.loadUrl(url);//更加传入的参数器加载新的网页
                return true;//希望跳转页面中当前Activity展示，不用打开新的浏览器
            }
        });
        webView.loadUrl("https://www.baidu.com");//传入url
    }
}

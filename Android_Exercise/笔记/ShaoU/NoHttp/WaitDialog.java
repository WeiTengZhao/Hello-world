package com.example.shao.testfengzhuang.NoHttp;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

/**
@ Description: 请求过程的提升对话框
**/
public class WaitDialog extends ProgressDialog {
    public WaitDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setMessage("正在请求，请稍后......");
        setProgressStyle(STYLE_SPINNER);
    }
}

package com.example.shao.testfengzhuang.NoHttp;

import android.content.Context;
import android.content.DialogInterface;

import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
@ Description:NoHttp onResponseListener的封装
**/
public class ResponseListener<T> implements OnResponseListener<T> {

    private Request<T> mrequest;
    private HttpCallBack<T> callBack;//定义接口对象
    private WaitDialog mDialog;//请求弹出对话框
    private boolean isShowError;//是否弹出错误提示提示信息

    public ResponseListener (Context context, final Request<T> request, HttpCallBack callBack, boolean isShowDialog, boolean isCancancle,boolean isShowError) {

        this.mrequest = request;
        this.callBack = callBack;
        if(context != null && isShowDialog) {
            mDialog = new WaitDialog(context);
            mDialog.setCancelable(isCancancle);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mrequest.cancel();//等待请求的对话框被用户关闭了，所以取消请求
                }
            });
        }
    }
    @Override
    public void onStart(int what) {
        if(mDialog != null && !mDialog.isShowing()) {
            mDialog.show();//显示Dialog
        }
    }

    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callBack != null) {
            callBack.onSucceed(what,response);//不为空，则创建请求成功对象
        }
    }

    @Override
    public void onFailed(int what, Response<T> response) {
        if (callBack != null) {
            callBack.onFailed(what,response);
        }
    }

    @Override
    public void onFinish(int what) {
        if(mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();//关闭Dialog
        }
    }
}

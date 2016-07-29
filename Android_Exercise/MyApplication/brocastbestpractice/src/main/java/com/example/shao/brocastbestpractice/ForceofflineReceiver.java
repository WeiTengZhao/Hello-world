package com.example.shao.brocastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by Shao on 2016/7/29.
 */
public class ForceofflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);//构建提示框
        dialog.setTitle("Warning");
        dialog.setMessage("将会关闭所有的Activity！");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityColletor.finishAll();//关闭所有Activity
                Intent intent1 = new Intent(context,LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//加入标志，使得Dialog能在接收器弹出
                context.startActivity(intent1);//跳回LoginActivity
            }
        });
        AlertDialog alertDialog = dialog.create(); //构建Dialog
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);//设置Dialog类型使得能在接收器弹出
        alertDialog.show();
    }
}

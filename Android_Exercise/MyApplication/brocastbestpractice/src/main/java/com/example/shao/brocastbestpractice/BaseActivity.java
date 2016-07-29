package com.example.shao.brocastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Shao on 2016/7/29.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityColletor.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityColletor.removeActivity(this);
    }
}

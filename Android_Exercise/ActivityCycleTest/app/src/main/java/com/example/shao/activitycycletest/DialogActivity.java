package com.example.shao.activitycycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_activity);
    }
}

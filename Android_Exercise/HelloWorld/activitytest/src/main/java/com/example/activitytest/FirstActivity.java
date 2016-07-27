package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Shao on 2016-07-22.
 */
public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
    }
}

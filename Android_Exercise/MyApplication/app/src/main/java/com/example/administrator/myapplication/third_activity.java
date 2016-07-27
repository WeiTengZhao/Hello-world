package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class third_activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityColletor.finishAllActivities();
            }
        });
    }
}

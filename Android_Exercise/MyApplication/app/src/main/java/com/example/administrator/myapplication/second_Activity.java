package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class second_Activity extends BaseActivity {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        String str = "Hello,MainActivity_Back";
        intent.putExtra("to_First_Activity",str);
        setResult(RESULT_OK,intent);
        finish();
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_Activity.this,third_activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Second_Activity","onDestory");
    }


}

package com.test.uisizetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        final float xdpi = getResources().getDisplayMetrics().xdpi;
        final float ydpi = getResources().getDisplayMetrics().ydpi;
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"xdpi:"+ xdpi + "\n"+"ydpi:" + ydpi,Toast.LENGTH_SHORT).show();
            }
        });
    }


}

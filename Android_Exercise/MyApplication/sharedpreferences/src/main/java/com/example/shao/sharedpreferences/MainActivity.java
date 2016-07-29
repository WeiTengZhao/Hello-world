package com.example.shao.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("Name","Yamato");
                editor.putInt("Age",23);
                editor.putBoolean("Mariged",true);
                editor.commit();
            }
        });
        button1 = (Button) findViewById(R.id.restore);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                String n = sharedPreferences.getString("Name","");
                int i = sharedPreferences.getInt("Age",0);
                boolean b = sharedPreferences.getBoolean("Mariged",true);

                Log.d("MainActivity","Name:"+ n);
                Log.d("MainActivity","Age:" + i);
                Log.d("MainActivity","Margied" + b);
            }
        });

    }
}

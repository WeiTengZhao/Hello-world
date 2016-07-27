package com.example.shao.uiweidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String inputText = editText.getText().toString();
                    Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    int progress = progressBar.getProgress();
                    if(progress >= 100 ) {
                        progress = 0;
                    } else {progress = progress + 10;}
                    progressBar.setProgress(progress);

                ProgressDialog.Builder progressDialog = new ProgressDialog.Builder(MainActivity.this);
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setMessage("Now Loading");
                progressDialog.setCancelable(true);//可以通过Back键取消
                progressDialog.show();//显示，取消显示用dismiss（）方法
            }
        });
    }
}

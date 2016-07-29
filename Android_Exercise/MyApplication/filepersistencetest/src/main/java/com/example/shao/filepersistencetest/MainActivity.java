package com.example.shao.filepersistencetest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String inputtext = load();
        if (!TextUtils.isEmpty(inputtext)) {
            editText.setText(inputtext);
            editText.setSelection(inputtext.length());
            Toast.makeText(MainActivity.this,"数据读取成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"Reading Falise",Toast.LENGTH_SHORT).show();
        }
    }

    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

       try {
           in = openFileInput("data");//获取输入流对象，从文件data获取
           reader = new BufferedReader(new InputStreamReader(in));
           String line = "";
           while ((line = reader.readLine() ) != null) { //判断输入行是否为空
               content.append(line);//在当前字符串后添加内容
           }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           try {
               if (reader != null) {
                   reader.close();
               }
           }catch (IOException e) {
               e.printStackTrace();
           }
       }
        return content.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String str = editText.getText().toString();
        save(str);
    }

     public void save(String inputstream) {
        FileOutputStream fileoutputstream = null;
        BufferedWriter writer = null;
        try {
            fileoutputstream = openFileOutput("data", Context.MODE_PRIVATE);//通过openFileOutout()获取数据流对象
            writer = new BufferedWriter(new OutputStreamWriter(fileoutputstream));//通过数据流进行写
            writer.write(inputstream);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

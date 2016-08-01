package com.example.shao.brocastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private Button login;
    private EditText account;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //获取login.xml中的view实例
        login = (Button) findViewById(R.id.login);
        account = (EditText) findViewById(R.id.account_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
       //写点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = account.getText().toString();
                String passwordstr = password.getText().toString();
                if(username.equals("admin") && passwordstr.equals("123456")) { //判断登录是否正确
                    Intent intent =  new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"登录信息出错",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

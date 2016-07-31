package com.example.shao.brocastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private Button login;
    private EditText account;
    private EditText password;
    private CheckBox checkBox;
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //获取login.xml中的view实例
        login = (Button) findViewById(R.id.login);
        account = (EditText) findViewById(R.id.account_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        pre = PreferenceManager.getDefaultSharedPreferences(this);
        final boolean pressFlag = pre.getBoolean("press_Flag",false);
        if(pressFlag) {//设置已存标签，若已存，则直接读取
            account.setText(pre.getString("username",null));
            password.setText(pre.getString("password",null));
            checkBox.setChecked(true);
        }
       //写点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = account.getText().toString();
                String passwordstr = password.getText().toString();
                editor = pre.edit();
                if(username.equals("admin") && passwordstr.equals("123456")) { //判断登录是否正确
                    if(checkBox.isChecked()) {
                        editor.putBoolean("press_Flag",true);
                        editor.putString("username",username);
                        editor.putString("password",passwordstr);
                    }else {editor.clear();}
                    editor.commit();
                    Intent intent =  new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"登录信息出错",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

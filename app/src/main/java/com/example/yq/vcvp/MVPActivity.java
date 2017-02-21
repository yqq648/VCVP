package com.example.yq.vcvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//Activity=view+control 代码非常的庞大，切不以维护
public class MVPActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_usename;
    EditText et_password;
    Button btn_login;
    Button btn_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        et_usename = (EditText) findViewById(R.id.et_usename);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_login.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_login){
            Toast.makeText(this, "login...", Toast.LENGTH_SHORT).show();
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MVPActivity.this, SecondActivity.class));
                }
            }, 2000);
        }else if(v.getId()==R.id.btn_clear){
            et_usename.setText("");
            et_password.setText("");
        }
    }
    //
    class MyUser{
        public boolean checkUserPwd(String u,String p){
            if (TextUtils.isEmpty(u)||TextUtils.isEmpty(p)){
                return true;
            }
            return false;
        }
    }
}

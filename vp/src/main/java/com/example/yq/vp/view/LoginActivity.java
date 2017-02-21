package com.example.yq.vp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yq.vp.R;
import com.example.yq.vp.SecondActivity;
import com.example.yq.vp.presenter.LoginPresenter;
//Activity现在只处理findView..setOnClick...
//view + presenter
//Activity=view+presenter(control) 代码非常的庞大，切不以维护
public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener,ILoginView {
    EditText et_usename;
    EditText et_password;
    Button btn_login;
    Button btn_clear;
    //
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        loginPresenter = new LoginPresenter(this);
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
            loginPresenter.doLogin(et_usename.getText().toString(),
                    et_password.getText().toString());
        }else if(v.getId()==R.id.btn_clear){
            loginPresenter.clear();
        }
    }
    //view  刷新界面
    @Override
    public void onClearText() {
        et_usename.setText("");
        et_password.setText("");
    }

    @Override
    public void onLoginResult() {
        Toast.makeText(this, "login...", Toast.LENGTH_SHORT).show();
        btn_login.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, SecondActivity.class));
            }
        }, 2000);
    }
}

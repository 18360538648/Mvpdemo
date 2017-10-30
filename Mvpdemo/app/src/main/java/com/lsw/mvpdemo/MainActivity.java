package com.lsw.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lsw.mvpdemo.mvp.bean.User;
import com.lsw.mvpdemo.mvp.presenter.UserLoginPresenter;
import com.lsw.mvpdemo.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_clean;
    private UserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        userLoginPresenter = new UserLoginPresenter(this);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clean = (Button) findViewById(R.id.btn_clean);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.login();
            }
        });
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        et_username.setText("");
    }

    @Override
    public void clearPassword() {
        et_password.setText("");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(getApplicationContext(), "登录成功用户名:" + user.getUserName() + " 密码:" + user.getPassword(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();

    }
}

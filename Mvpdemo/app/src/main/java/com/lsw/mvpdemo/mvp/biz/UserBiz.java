package com.lsw.mvpdemo.mvp.biz;

import com.lsw.mvpdemo.mvp.bean.User;

/**
 * Created by Luosiwei on 2017/10/30.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(String username, String password, OnLoginListener onLoginListener) {
        if (username.equals(password)) {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            onLoginListener.loginSuccess(user);
        } else {
            onLoginListener.loginFailed();
        }
    }
}

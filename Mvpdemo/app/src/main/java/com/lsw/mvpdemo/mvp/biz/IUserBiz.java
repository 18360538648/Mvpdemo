package com.lsw.mvpdemo.mvp.biz;

/**
 * Created by Luosiwei on 2017/10/30.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener onLoginListener);
}

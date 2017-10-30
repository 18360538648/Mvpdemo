package com.lsw.mvpdemo.mvp.biz;

import com.lsw.mvpdemo.mvp.bean.User;

/**
 * Created by Luosiwei on 2017/10/30.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}

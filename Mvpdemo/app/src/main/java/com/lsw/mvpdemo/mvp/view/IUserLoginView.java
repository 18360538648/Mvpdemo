package com.lsw.mvpdemo.mvp.view;

import com.lsw.mvpdemo.mvp.bean.User;

/**
 * Created by Luosiwei on 2017/10/30.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}

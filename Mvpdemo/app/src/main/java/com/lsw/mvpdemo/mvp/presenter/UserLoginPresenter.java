package com.lsw.mvpdemo.mvp.presenter;

import android.os.Handler;

import com.lsw.mvpdemo.mvp.bean.User;
import com.lsw.mvpdemo.mvp.biz.IUserBiz;
import com.lsw.mvpdemo.mvp.biz.OnLoginListener;
import com.lsw.mvpdemo.mvp.biz.UserBiz;
import com.lsw.mvpdemo.mvp.view.IUserLoginView;

/**
 * Created by Luosiwei on 2017/10/30.
 */

public class UserLoginPresenter {
    private IUserLoginView iUserLoginView;
    private IUserBiz iUserBiz;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.iUserBiz = new UserBiz();
    }

    public void login() {
        iUserLoginView.showLoading();
        iUserBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        iUserLoginView.clearPassword();
        iUserLoginView.clearUserName();
    }

}

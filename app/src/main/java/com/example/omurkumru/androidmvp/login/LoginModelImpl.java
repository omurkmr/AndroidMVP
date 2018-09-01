package com.example.omurkumru.androidmvp.login;

import android.os.Handler;

import com.example.omurkumru.androidmvp.LoginResultListener;


public class LoginModelImpl implements  LoginModel {

    final String name = "test";
    final String pass = "1234";

    @Override
    public void doLogin(final String userName, final String password, final LoginResultListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userName.equals(name)&&password.equals(pass)){
                    listener.onSuccess();
                }else {
                    listener.onFail();
                }
            }
        }, 450);
    }
}

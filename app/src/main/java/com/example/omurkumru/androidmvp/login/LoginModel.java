package com.example.omurkumru.androidmvp.login;

import com.example.omurkumru.androidmvp.LoginResultListener;

public interface LoginModel {

    //doing hardWork here, send request,parse response etc.
    void doLogin(String userName, String password , LoginResultListener listener);
}

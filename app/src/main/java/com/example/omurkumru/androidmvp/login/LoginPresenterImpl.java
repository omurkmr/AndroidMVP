package com.example.omurkumru.androidmvp.login;

import com.example.omurkumru.androidmvp.LoginResultListener;

public class LoginPresenterImpl implements LoginPresenter {

    private final LoginModel model;
    private final LoginView view;

    public LoginPresenterImpl(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void login(String userName, String password) {
        view.showLoading();

        model.doLogin(userName, password, new LoginResultListener() {
            @Override
            public void onSuccess() {
                view.navigateToHome();
            }

            @Override
            public void onFail() {
                view.hideLoading();
                view.showError("Ups, wrong credentials budy");
            }
        });
    }
}

package com.example.omurkumru.androidmvp.login;

import android.view.View;

public interface LoginView {

    //showing Loading animation while waiting
    void showLoading();

    //ethernal waiting finally ends
    void hideLoading();

    //ups, something went terribly wrong
    void showError(String errorMessage);

    //hurray, everything is ok
    void navigateToHome();

}

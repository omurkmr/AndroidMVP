package com.example.omurkumru.androidmvp.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.omurkumru.androidmvp.R;
import com.example.omurkumru.androidmvp.home.HomeActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginViewImpl extends AppCompatActivity implements LoginView{

    @Bind(R.id.username)
    EditText usernameET;

    @Bind(R.id.password)
     EditText passwordET;

    @Bind(R.id.loginButton)
     Button loginButton;

    @Bind(R.id.loading)
     ProgressBar loading;

    protected LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view_impl);
        ButterKnife.bind(this);

        //must add dependency injection(dagger)
        presenter = new LoginPresenterImpl(new LoginModelImpl(),this);

    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.INVISIBLE);

    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @OnClick(R.id.loginButton)
    public void loginClick(View view) {
        String userVal = usernameET.getText().toString().trim();
        String passVal = passwordET.getText().toString().trim();
        presenter.login(userVal,passVal);
    }
}

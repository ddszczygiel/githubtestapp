package com.crustlab.githubapp.ui.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.crustlab.githubapp.R;
import com.crustlab.githubapp.model.remote.UserEntity;
import com.crustlab.githubapp.service.GithubNetworkService;
import com.crustlab.githubapp.service.SharedPreferencesLocalStorage;
import com.crustlab.githubapp.ui.main.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_username)
    EditText etEmail;

    @BindView(R.id.btn_login)
    Button btnLogin;

    private ProgressDialog progressDialog;

    public static Intent getIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupProgressDialog();

        checkIfUserLogged();
    }

    @Override
    protected void onDestroy() {
        progressDialog.dismiss();
        super.onDestroy();
    }

    @OnClick(R.id.btn_login)
    void loginBtnClicked() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        String token = GithubNetworkService.prepareAuthorizationToken(email, password);
        attemptLogin(token);
    }

    private void checkIfUserLogged() {
        if (SharedPreferencesLocalStorage.getInstance().getUserToken() != null) {
            showMainActivity();
        }
    }

    private void attemptLogin(final String token) {
        showProgressBar();
        GithubNetworkService.getInstance().getGithubService()
                .authorize(token)
                .enqueue(new Callback<UserEntity>() {

                    @Override
                    public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                        if (response.isSuccessful()) {
                            SharedPreferencesLocalStorage.getInstance().storeUserToken(token);
                            hideProgressBar();
                            showMainActivity();
                        } else {
                            onLoginError();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserEntity> call, Throwable t) {
                        onLoginError();
                    }
                });
    }

    private void onLoginError() {
        hideProgressBar();
        Toast.makeText(this, "Could not authorize - try again", Toast.LENGTH_SHORT).show();
    }

    private void showMainActivity() {
        startActivity(MainActivity.getIntent(this));
        finish();
    }

    private void showProgressBar() {
        progressDialog.show();
    }

    private void hideProgressBar() {
        progressDialog.hide();
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.progress_dialog_text));
    }
}

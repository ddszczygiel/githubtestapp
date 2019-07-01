package com.crustlab.githubapp.ui.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.crustlab.githubapp.R;
import com.crustlab.githubapp.model.ModelMapper;
import com.crustlab.githubapp.model.Repository;
import com.crustlab.githubapp.model.remote.RepositoryEntity;
import com.crustlab.githubapp.service.GithubNetworkService;
import com.crustlab.githubapp.service.SharedPreferencesLocalStorage;
import com.crustlab.githubapp.ui.login.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_repo_list)
    RecyclerView rvRepositoryList;

    @BindView(R.id.btn_add_repo)
    Button btnAddRepository;

    @BindView(R.id.btn_logout)
    Button btLogout;

    RepositoryListAdapter repositoryListAdapter;

    private ProgressDialog progressDialog;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        repositoryListAdapter = new RepositoryListAdapter(this);
        setupRecyclerView();
        setupProgressDialog();

        getWindow().getDecorView().postDelayed(this::getRepositoryList, 2000);
    }

    @Override
    protected void onDestroy() {
        progressDialog.dismiss();
        super.onDestroy();
    }

    @OnClick(R.id.btn_add_repo)
    void addRepositoryBtnClicked() {
        showAddRepositoryDialog();
    }

    @OnClick(R.id.btn_logout)
    void logoutBtnClicked() {
        performLogout();
    }

    private void showProgressBar() {
        progressDialog.show();
    }

    private void hideProgressBar() {
        progressDialog.hide();
    }

    private void performLogout() {
        SharedPreferencesLocalStorage.getInstance().clear();
        startActivity(LoginActivity.getIntent(this));
        finish();
    }

    private void addRepository(String repoName) {
        showProgressBar();
        Repository repo = new Repository(repoName, null, null, null);
        GithubNetworkService.getInstance().getGithubService()
                .createRepository(ModelMapper.getInstance().toEntity(repo))
                .enqueue(new Callback<RepositoryEntity>() {

                    @Override
                    public void onResponse(Call<RepositoryEntity> call, Response<RepositoryEntity> response) {
                        if (response.isSuccessful()) {
                            onAddRepoSuccess();
                        } else {
                            onAddRepoError();
                        }
                    }

                    @Override
                    public void onFailure(Call<RepositoryEntity> call, Throwable t) {
                        onAddRepoError();
                    }
                });
    }

    private void onAddRepoSuccess() {
        hideProgressBar();
        Toast.makeText(MainActivity.this, R.string.add_repository_success_text, Toast.LENGTH_SHORT).show();
        getWindow().getDecorView().postDelayed(this::getRepositoryList, 2000);
    }

    private void onAddRepoError() {
        hideProgressBar();
        Toast.makeText(MainActivity.this, R.string.add_repository_failure_text, Toast.LENGTH_SHORT).show();
    }

    private void deleteRepository(Repository repository) {
        showProgressBar();
        GithubNetworkService.getInstance().getGithubService()
                .deleteRepository(repository.getOwner(), repository.getName())
                .enqueue(new Callback<Void>() {

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            onDeleteRepoSuccess();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        onDeleteRepoError();
                    }
                });
    }

    private void onDeleteRepoError() {
        hideProgressBar();
        Toast.makeText(MainActivity.this, R.string.delete_repository_failure_text, Toast.LENGTH_SHORT).show();
    }

    private void onDeleteRepoSuccess() {
        hideProgressBar();
        Toast.makeText(MainActivity.this, R.string.delete_repository_success_text, Toast.LENGTH_SHORT).show();
        getWindow().getDecorView().postDelayed(this::getRepositoryList, 2000);
    }

    private void getRepositoryList() {
        showProgressBar();
        GithubNetworkService.getInstance().getGithubService()
                .getRepositories()
                .enqueue(new Callback<List<RepositoryEntity>>() {

                    @Override
                    public void onResponse(Call<List<RepositoryEntity>> call, Response<List<RepositoryEntity>> response) {
                        if (response.isSuccessful()) {
                            onGetRepoListSuccess(response.body());
                        } else {
                            onRepositoryListError(new Throwable("Could not get repo list"));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RepositoryEntity>> call, Throwable t) {
                        onRepositoryListError(t);
                    }
                });
    }

    private void onGetRepoListSuccess(List<RepositoryEntity> list) {
        hideProgressBar();
        repositoryListAdapter.updateRepositoryList(mapRepositories(list));
    }

    private void onRepositoryListError(Throwable t) {
        hideProgressBar();
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private List<Repository> mapRepositories(List<RepositoryEntity> repositoryEntities) {
        List<Repository> repositories = new ArrayList<>();
        for (RepositoryEntity repositoryEntity : repositoryEntities) {
            repositories.add(ModelMapper.getInstance().fromEntity(repositoryEntity));
        }
        return repositories;
    }

    private void setupRecyclerView() {
        repositoryListAdapter.setLongClickListener(this::showRepositoryDeleteConfirmationDialog);
        rvRepositoryList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvRepositoryList.setAdapter(repositoryListAdapter);
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.progress_dialog_text));
    }

    private void showAddRepositoryDialog() {
        AlertDialog.Builder builder = getAddRepositoryDialogBuilder();
        builder.show();
    }

    @NonNull
    private AlertDialog.Builder getAddRepositoryDialogBuilder() {
        final EditText etRepoName = new EditText(this);
        etRepoName.setInputType(InputType.TYPE_CLASS_TEXT);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_repo_dialog_title)
                .setView(etRepoName)
                .setNegativeButton(R.string.add_repo_dialog_negative_btn_text, (dialog, i) -> dialog.cancel())
                .setPositiveButton(R.string.add_repo_dialog_positive_btn_text,
                        (dialog, i) -> {
                            String repoName = etRepoName.getText().toString().trim();
                            addRepository(repoName);
                        });
        return builder;
    }


    public boolean showRepositoryDeleteConfirmationDialog(Repository repository) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.delete_repository_dialog_title)
                .setMessage(getString(R.string.delete_repository_dialog_message, repository.getName()))
                .setPositiveButton(R.string.btn_text_yes, (dialogInterface, i) -> deleteRepository(repository))
                .setNegativeButton(R.string.btn_text_no, (dialogInterface, i) -> dialogInterface.dismiss())
                .create()
                .show();
        return true;
    }
}

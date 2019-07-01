package com.crustlab.githubapp.service;

import java.util.List;

import com.crustlab.githubapp.model.remote.NewRepositoryEntity;
import com.crustlab.githubapp.model.remote.RepositoryEntity;
import com.crustlab.githubapp.model.remote.UserEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GithubService {

    String GITHUB_URL = "https://api.github.com/";

    @GET("user")
    Call<UserEntity> authorize(@Header("Authorization") String baseToken);

    @GET("user/repos")
    Call<List<RepositoryEntity>> getRepositories();

    @POST("user/repos")
    Call<RepositoryEntity> createRepository(@Body NewRepositoryEntity newRepositoryEntity);

    @DELETE("repos/{owner}/{repo}")
    Call<Void> deleteRepository(@Path("owner") String owner, @Path("repo") String repo);
}
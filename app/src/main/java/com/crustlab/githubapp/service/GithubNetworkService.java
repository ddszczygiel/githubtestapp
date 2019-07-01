package com.crustlab.githubapp.service;

import android.util.Base64;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.crustlab.githubapp.service.GithubService.GITHUB_URL;

public class GithubNetworkService {

    private static GithubNetworkService INSTANCE;

    public static void initialize(InterceptorFactory interceptorFactory) {
        INSTANCE = new GithubNetworkService(interceptorFactory);
    }

    public static GithubNetworkService getInstance() {
        return INSTANCE;
    }

    private static final String TOKEN_PREFIX = "Basic ";

    private final GithubService githubService;

    public GithubService getGithubService() {
        return githubService;
    }

    private GithubNetworkService(InterceptorFactory interceptorFactory) {
        OkHttpClient httpClient = createHttpClient(interceptorFactory);
        this.githubService = createGithubService(httpClient);
    }

    private GithubService createGithubService(OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(GITHUB_URL)
                .client(httpClient)
                .build()
                .create(GithubService.class);
    }

    private OkHttpClient createHttpClient(InterceptorFactory interceptorFactory) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptorFactory.getGithubInterceptor())
                .addInterceptor(interceptorFactory.getAuthorizationInterceptor())
                .addInterceptor(interceptorFactory.getLoggingInterceptor())
                .build();
    }

    public static String prepareAuthorizationToken(String username, String password) {
        String authString = username + ":" + password;
        return TOKEN_PREFIX + Base64.encodeToString(authString.getBytes(), Base64.NO_WRAP);
    }
}

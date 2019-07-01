package com.crustlab.githubapp;

import android.app.Application;

import com.crustlab.githubapp.service.GithubNetworkService;
import com.crustlab.githubapp.service.InterceptorFactory;
import com.crustlab.githubapp.service.SharedPreferencesLocalStorage;

public class GithubApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesLocalStorage.initialize(this);
        InterceptorFactory.initialize(SharedPreferencesLocalStorage.getInstance());
        GithubNetworkService.initialize(InterceptorFactory.getInstance());
    }
}

package com.crustlab.githubapp.service;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesLocalStorage {

    private static SharedPreferencesLocalStorage INSTANCE;

    public static void initialize(Context context) {
        INSTANCE = new SharedPreferencesLocalStorage(context);
    }

    public static SharedPreferencesLocalStorage getInstance() {
        return INSTANCE;
    }

    private static final String SHARED_PREF_FILE = "github_file";
    private static final String SP_KEY_TOKEN = "auth_token";

    private final SharedPreferences sharedPreferences;

    private SharedPreferencesLocalStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE,
                Context.MODE_PRIVATE);
    }

    public void storeUserToken(String authToken) {
        sharedPreferences.edit()
                .putString(SP_KEY_TOKEN, authToken)
                .apply();
    }

    public String getUserToken() {
        return sharedPreferences.getString(SP_KEY_TOKEN, null);
    }

    public void clear() {
        sharedPreferences.edit()
                .clear()
                .apply();
    }
}

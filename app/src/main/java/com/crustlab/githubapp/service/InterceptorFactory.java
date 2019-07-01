package com.crustlab.githubapp.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorFactory {

    private static InterceptorFactory INSTANCE;

    public static void initialize(SharedPreferencesLocalStorage localStorage) {
        INSTANCE = new InterceptorFactory(localStorage);
    }

    public static InterceptorFactory getInstance() {
        return INSTANCE;
    }

    private final String ACCEPT_HEADER = "Accept";
    private final String ACCEPT_HEADER_VALUE = "application/vnd.github.v3+json";

    private final SharedPreferencesLocalStorage localStorage;

    private InterceptorFactory(SharedPreferencesLocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    public Interceptor getGithubInterceptor() {
        return chain -> {
            Request request = chain
                    .request()
                    .newBuilder()
                    .addHeader(ACCEPT_HEADER, ACCEPT_HEADER_VALUE)
                    .build();
            return chain.proceed(request);
        };
    }

    public Interceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor(localStorage);
    }

    public Interceptor getLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    static class AuthorizationInterceptor implements Interceptor {

        private final String AUTHORIZATION_HEADER = "Authorization";
        private final SharedPreferencesLocalStorage localStorage;

        public AuthorizationInterceptor(SharedPreferencesLocalStorage localStorage) {
            this.localStorage = localStorage;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            String userToken = localStorage.getUserToken();
            if (userToken == null) {
                return chain.proceed(chain.request());
            } else {
                Request request = chain
                        .request()
                        .newBuilder()
                        .addHeader(AUTHORIZATION_HEADER, userToken)
                        .build();
                return chain.proceed(request);
            }
        }
    }
}
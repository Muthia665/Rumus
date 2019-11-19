package com.example.user.rumus;

public class ConfigApi {
    public static final String BASE_URL = "http://192.168.100.4/userver/";

    public static BaseApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(BaseApiService.class);
    }
}


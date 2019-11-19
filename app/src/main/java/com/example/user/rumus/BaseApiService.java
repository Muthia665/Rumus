package com.example.user.rumus;

import com.example.user.rumus.model.ResponseLogin;
import com.example.user.rumus.model.ResponseRegis;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(@Field("username")String username,
                              @Field("password")String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseRegis> register(@Field("nama_user") String nama,
                                 @Field("username")String username,
                                 @Field("password")String password);
}

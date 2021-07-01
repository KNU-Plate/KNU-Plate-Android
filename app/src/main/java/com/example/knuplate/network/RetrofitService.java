package com.example.knuplate.network;

import com.example.knuplate.model.*;
import com.example.knuplate.model.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("api/login")
    Call<UserData> postUserData(@FieldMap HashMap<String, String> param);

    @FormUrlEncoded
    @POST("api/signup")
    Call<SignUpData> postSignUpData(@FieldMap HashMap<String, String> param);

    @GET("api/mall")
    Call<List<MallData>> getMallData(@QueryMap HashMap<String, String> param);
}

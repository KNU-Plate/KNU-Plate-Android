package com.example.knuplate.network;

import com.example.knuplate.model.*;
import com.example.knuplate.model.UserData;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface RetrofitService {

    @FormUrlEncoded
    @POST("api/login")
    Call<UserData> postUserData(@FieldMap HashMap<String, String> param);

    @FormUrlEncoded
    @POST("api/signup")
    Call<SignUpData> postSignUpData(@FieldMap HashMap<String, String> param);

    @GET("api/notice")
    Call<List<NoticeData>> getNoticeData(@Query("number") int cursor);

    @GET("api/review")
    Call<List<ReviewData>> getReviewData(@Query("number") int mall_id, @Query("number") int cursor, @Query("string") String myReview);

    @GET("api/mall")
    Call<List<MallData>> getMallData(@QueryMap HashMap<String, String> param);

    @GET("api/mall/{mall_id}")
    Call<MallDetailData> getMallDetailData(@Path("mall_id") Integer mall_id);

}

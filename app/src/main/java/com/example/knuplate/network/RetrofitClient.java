package com.example.knuplate.network;

import android.util.Log;

import com.example.knuplate.data.*;
import com.example.knuplate.data.mall.MallData;
import com.example.knuplate.data.mall.MallDetailData;
import com.example.knuplate.data.mall.ReviewData;
import com.example.knuplate.data.search.SearchData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String SC_TAG = "RetrofitCommunication";
    private static Gson gson;
    private static Retrofit retrofit;
    private static RetrofitService service;

    // ** 레트로핏 요청 (콜백함수, 요청구분, 파라미터) ** //
    public static void request(Callback callback, String gubun, final HashMap<String, String> hashMap) {
        Log.d(SC_TAG, "=========> 요청 : " + gubun);

        if (gson == null) {
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://222.104.199.114:4100/") // 서버 호스트
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        if (service == null) {
            service = retrofit.create(RetrofitService.class);
        }

        if ("call_login".equals(gubun)) {
            Call<UserData> call = service.postUserData(hashMap);
            call.enqueue(callback);
        }

        if ("call_signup".equals(gubun)) {
            Call<SignUpData> call = service.postSignUpData(hashMap);
            call.enqueue(callback);
        }

        if ("call_mall_list".equals(gubun)) {
            Call<List<MallData>> call = service.getMallData(hashMap);
            call.enqueue(callback);
        }

        if ("call_mall_detail".equals(gubun)) {
            String mallId = hashMap.get("mall_id");
            Integer mallId_Int = Integer.parseInt(mallId);
            Call<MallDetailData> call = service.getMallDetailData(mallId_Int);
            call.enqueue(callback);
        }

        if ("call_review".equals(gubun)) {
            String mallId = hashMap.get("mall_id");
            Integer mallId_Int = Integer.parseInt(mallId);
            Call<List<ReviewData>> call = service.getReviewData(mallId_Int, "N");
            call.enqueue(callback);
        }

        if ("call_notice".equals(gubun)) {
            Call<List<NoticeData>> call = service.getNoticeData(0);
            call.enqueue(callback);
        }

        if ("call_search".equals(gubun)) {
            Call<SearchData> call = service.getSearchData(hashMap);
            call.enqueue(callback);
        }

    }

}

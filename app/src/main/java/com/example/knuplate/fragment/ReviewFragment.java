package com.example.knuplate.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.knuplate.adapter.ReviewAdapter;
import com.example.knuplate.R;
import com.example.knuplate.data.mall.ReviewData;
import com.example.knuplate.network.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewFragment extends Fragment {

    View v;
    Integer mallId;
    RecyclerView reviewRecyclerView;
    ReviewAdapter reviewAdapter;

    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_review, container, false);

        //DetailActivity로부터 mall ID 받아오기
        mallId = getArguments().getInt("mall_id");
        Log.d("cb", mallId.toString());

        //리뷰 목록 호출
        HashMap<String,String> hashMap= new HashMap<String,String>();
        hashMap.put("mall_id", mallId.toString()); //value를 string으로 변환해서 넘겨야 함
        RetrofitClient.request(cbReview, "call_review", hashMap);

        //리사이클러뷰 생성
        reviewRecyclerView = v.findViewById(R.id.recyclerView);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //어댑터 붙이기
        reviewAdapter = new ReviewAdapter();
        reviewRecyclerView.setAdapter(reviewAdapter);

        return v;
    }

    Callback cbReview = new Callback<List<ReviewData>>(){
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbReview()";

        @Override
        public void onResponse(Call<List<ReviewData>> call, Response<List<ReviewData>> response) {
            if (response.isSuccessful()) {
                List<ReviewData> reviewDataList = response.body();

                Log.d(TAG, cbTAG + String.valueOf(reviewDataList.size()));

                for(int i=0; i<reviewDataList.size(); i++){
                    reviewAdapter.addItem(reviewDataList.get(i));
                }

                //데이터가 변화했음을 어댑터에게 알려줌
                reviewAdapter.notifyDataSetChanged();

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getContext(), "Review 받아오기 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<ReviewData>> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + t);
        }
    };
}
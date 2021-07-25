package com.example.knuplate.Fragment;

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

import com.example.knuplate.Adapter.ReviewAdapter;
import com.example.knuplate.R;
import com.example.knuplate.model.ReviewData;
import com.example.knuplate.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Review extends Fragment {

    View v;

    public static Fragment_Review newInstance() {
        return new Fragment_Review();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_review, container, false);


        RetrofitClient.requestGet(cbReview, "call_review");

        return v;
    }

    Callback cbReview = new Callback<List<ReviewData>>(){
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbReview()";

        @Override
        public void onResponse(Call<List<ReviewData>> call, Response<List<ReviewData>> response) {
            if (response.isSuccessful()) {
                List<ReviewData> reviewData = response.body();

                RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                //test
                ArrayList<ReviewData> arrayList = new ArrayList<>(reviewData);
                ReviewAdapter reviewAdapter = new ReviewAdapter(arrayList);

                recyclerView.setAdapter(reviewAdapter);

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
package com.example.knuplate.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knuplate.adapter.RestAdapter;
import com.example.knuplate.DetailActivity;
import com.example.knuplate.R;
import com.example.knuplate.data.mall.MallData;
import com.example.knuplate.network.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestListFragment extends Fragment {

    // TODO: Rename and change types of parameters

    private RecyclerView recyclerView;
    private RestAdapter adapter;
    private String category_name;
    private TextView textView;
    private GridLayoutManager gridLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //액티비티로부터 번들을 통해 카테고리 이름 받아오기
        category_name = getArguments().getString("category_name");

        View view = inflater.inflate(R.layout.fragment_rest_list, null);

        //식당 목록 호출
        HashMap<String, String> mallMap = new HashMap<>();
        mallMap.put("category_name", category_name);
        RetrofitClient.request(cbMallList, "call_mall_list", mallMap);

        recyclerView = view.findViewById(R.id.restList);
        gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //어댑터 세팅
        adapter = new RestAdapter();
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    Callback cbMallList = new Callback<List<MallData>>() {
        private final static String TAG = "Retrofit_MallList";
        String cbTAG = "레트로핏 - cbMallList()";

        @Override
        public void onResponse(Call<List<MallData>> call, Response<List<MallData>> response) {
            if (response.isSuccessful()) {
                List<MallData> mallDataList = response.body();

                for(int i=0; i<mallDataList.size(); i++){
                    Log.d(TAG, cbTAG + mallDataList.get(i).getMall_name());
                    adapter.addItem(mallDataList.get(i));
                }

                adapter.setOnItemClickListener((v, pos) -> {
                    Toast.makeText(getContext(), mallDataList.get(pos).getMall_name(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), DetailActivity.class);

                    //인텐트로 mall id 넘기기
                    intent.putExtra("mall_id", mallDataList.get(pos).getMall_id());
                    startActivity(intent);
                });

                adapter.notifyDataSetChanged(); //아이템이 변화함을 알림

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getActivity(), "식당 불러오기 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<MallData>> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + category_name + t);
        }
    };
}
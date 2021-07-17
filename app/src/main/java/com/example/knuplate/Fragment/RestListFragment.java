package com.example.knuplate.Fragment;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knuplate.MainActivity;
import com.example.knuplate.R;
import com.example.knuplate.model.MallData;
import com.example.knuplate.model.UserData;
import com.example.knuplate.network.RetrofitClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestListFragment extends Fragment {

    // TODO: Rename and change types of parameters

    RecyclerView completedList;
    private String category;
    private TextView textView;

    public RestListFragment(String category) {
        // Required empty public constructor
        this.category = category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rest_list, null);
        textView = (TextView)view.findViewById(R.id.frag_tv);
        textView.setText(category);

        HashMap<String, String> mallMap = new HashMap<>();

        mallMap.put("category_name", category);
        RetrofitClient.request(cbMallList, "call_mall_list", mallMap);

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
                }

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getActivity(), "식당 불러오기 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<MallData>> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + t);
        }
    };
}
package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.knuplate.model.NoticeData;
import com.example.knuplate.model.UserData;
import com.example.knuplate.network.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_notice);

        final HashMap<String, String> loginMap = new HashMap();

        listView = findViewById(R.id.notice_lv);
        RetrofitClient.requestGet(cbNotice, "call_notice");

    }

    Callback cbNotice = new Callback<List<NoticeData>>(){
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbNotice()";

        @Override
        public void onResponse(Call<List<NoticeData>> call, Response<List<NoticeData>> response) {
            if (response.isSuccessful()) {
                List<NoticeData> noticeData = response.body();
                //ListView 뿌려줄 ArrayList 생성
                ArrayList<String> noticeArray = new ArrayList<>();
                for(NoticeData nd : noticeData){
                    noticeArray.add(nd.getContents());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(NoticeActivity.this, R.layout.item_notice, R.id.tv_notice_contents, noticeArray);
                listView.setAdapter(adapter);

                Toast.makeText(getApplicationContext(), "공지사항 받아오기 Complete", Toast.LENGTH_SHORT).show();

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getApplicationContext(), "공지사항 받아오기 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<NoticeData>> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + t);
        }
    };
}
package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.knuplate.adapter.NoticeAdapter;
import com.example.knuplate.data.NoticeData;
import com.example.knuplate.network.RetrofitClient;

import java.util.ArrayList;
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

        //listView = findViewById(R.id.notice_lv);
        RetrofitClient.request(cbNotice, "call_notice", null);

    }

    Callback cbNotice = new Callback<List<NoticeData>>(){
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbNotice()";

        @Override
        public void onResponse(Call<List<NoticeData>> call, Response<List<NoticeData>> response) {
            if (response.isSuccessful()) {
                /*
                List<NoticeData> noticeData = response.body();
                //ListView 뿌려줄 ArrayList 생성
                ArrayList<String> noticeArray = new ArrayList<>();
                for(NoticeData nd : noticeData){
                    noticeArray.add(nd.getContents());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(NoticeActivity.this, R.layout.item_notice, R.id.tv_notice_contents, noticeArray);
                listView.setAdapter(adapter);
                 */

                List<NoticeData> noticeData = response.body();

                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(NoticeActivity.this, LinearLayoutManager.VERTICAL, false));
                //test
                ArrayList<NoticeData> noticeList = new ArrayList<>(noticeData);
                NoticeAdapter noticeAdapter = new NoticeAdapter(noticeList);

                recyclerView.setAdapter(noticeAdapter);

                Log.d(TAG, cbTAG + "데이터 받아오기 완료");

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
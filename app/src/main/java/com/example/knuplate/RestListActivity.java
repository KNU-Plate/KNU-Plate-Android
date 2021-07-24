package com.example.knuplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.example.knuplate.Adapter.RestListAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class RestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_list);

        ViewPager2 vp = findViewById(R.id.RestListViewPager); //뷰페이저
        RestListAdapter restListAdapter = new RestListAdapter(this); //어댑터
        vp.setAdapter(restListAdapter); //뷰페이저에 어댑터 설정

        TabLayout tab = findViewById(R.id.restListTap);

        tab.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));

        //카테고리 이름 리스트
        final List<String> tabElement = Arrays.asList("한식", "중식", "일식", "세계 음식", "카페", "양식", "술집");

        new TabLayoutMediator(tab, vp, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(RestListActivity.this);
                textView.setText(tabElement.get(position));
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                tab.setCustomView(textView);
            }
        }).attach();

    }
}
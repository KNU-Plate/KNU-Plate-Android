package com.example.knuplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MyTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);

        LinearLayout menu1 = findViewById(R.id.mytab_menu1);
        LinearLayout menu2 = findViewById(R.id.mytab_menu2);
        LinearLayout menu3 = findViewById(R.id.mytab_menu3);
        LinearLayout menu4 = findViewById(R.id.mytab_menu4);
        LinearLayout menu5 = findViewById(R.id.mytab_menu5);
        LinearLayout menu6 = findViewById(R.id.mytab_menu6);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTabActivity.this ,NoticeActivity.class);
                startActivity(intent);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTabActivity.this ,SuggestActivity.class);
                startActivity(intent);
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTabActivity.this ,SettingActivity.class);
                startActivity(intent);
            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MyTabActivity.this ,NoticeActivity.class);
                //startActivity(intent);
            }
        });

        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MyTabActivity.this ,NoticeActivity.class);
                //startActivity(intent);
            }
        });

        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MyTabActivity.this ,NoticeActivity.class);
                //startActivity(intent);
            }
        });


        //BottomNav
        BottomNavigationView bottom_menu = (BottomNavigationView) findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Intent intent1 = new Intent(getApplicationContext(), RestListActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.tab2:
                        return true;
                    case R.id.tab3:
                        Intent intent3 = new Intent(getApplicationContext(), MyTabActivity.class);
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        });

    }
}
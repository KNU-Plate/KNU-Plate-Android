package com.example.knuplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.knuplate.adapter.RestAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private RestAdapter adapter;
    private LinearLayout bt_northgate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHashKey(); //해시 키 가져오기

        recyclerView = findViewById(R.id.restList);
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //어댑터 세팅
        adapter = new RestAdapter();
        recyclerView.setAdapter(adapter);

        bt_northgate = findViewById(R.id.bt_northgate);
        bt_northgate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestListActivity.class);
                startActivity(intent);
            }
        });


        //BottomNav
        BottomNavigationView bottom_menu = (BottomNavigationView) findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
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

    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setTitle("크슐랭가이드를 종료하시겠습니까?");
        d.setMessage("크슐랭가이드를 방문해주셔서 감사합니다 :)");
        d.setIcon(R.drawable.main_icon);

        d.setNegativeButton("종료하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finishAffinity();
                System.runFinalization();
                System.exit(0);
                //finish();
            }
        });
        d.show();
    }
}

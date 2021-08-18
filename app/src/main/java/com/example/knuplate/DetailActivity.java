package com.example.knuplate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knuplate.Adapter.UriImageAdapter;
import com.example.knuplate.Fragment.Fragment_Location;
import com.example.knuplate.Fragment.Fragment_Menu;
import com.example.knuplate.Fragment.Fragment_Review;
import com.example.knuplate.model.MallDetailData;
import com.example.knuplate.model.dto.MenuData;
import com.example.knuplate.network.RetrofitClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView mallTitle;
    TextView mallName;
    TextView mallLocated;
    TextView mallCategory;

    Button button;
    RecyclerView recyclerView;
    int CODE_ALBUM_REQUEST = 111;
    Fragment review_fragment, menu_fragment, location_fragment;
    ArrayList<Uri> uriList = new ArrayList<>();
    UriImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mallTitle = findViewById(R.id.mallTitle);
        mallName = findViewById(R.id.name_text_detail);
        mallLocated = findViewById(R.id.locate_text_detail);
        mallCategory = findViewById(R.id.foodCategory_text_detail);

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

        //toolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView likebut_detail = findViewById(R.id.likebut_detail);
        ImageView ratebut_detail = findViewById(R.id.ratebut_detail);
        button = findViewById(R.id.button);

        //식당 id, 메뉴목록 받아오기
        Intent getIntent = getIntent();
        Integer mallId = getIntent.getIntExtra("mall_id",0);
        List<String> mallMenus = getIntent.getStringArrayListExtra("mall_menu");


        //상세 정보 호출
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("mall_id", mallId.toString());
        RetrofitClient.request(cbMallDetail, "call_mall_detail", hashMap);

        //TabLayout-FragmentLayout
        review_fragment = new Fragment_Review();
        menu_fragment = new Fragment_Menu();
        location_fragment = new Fragment_Location();

        //사진 리사이클러뷰
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;

                if (position == 0) {
                    selected = review_fragment;
                } else if (position == 1) {
                    selected = location_fragment;
                } else if (position == 2) {
                    selected = menu_fragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //리사이클러뷰 사진선택 code
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, CODE_ALBUM_REQUEST);

            }
        });

        //하트, 별 클릭리스너
        likebut_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likebut_detail != null) {
                    likebut_detail.setSelected(!likebut_detail.isSelected());
                }
            }
        });

        ratebut_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratebut_detail != null) {
                    ratebut_detail.setSelected(!ratebut_detail.isSelected());
                }
            }
        });

        //권한
        setPermissionCheckListener(new PermissionCheckListener() {
            @Override
            public void permissionCheckFinish() {
                Log.e("log", "permission_complete");
            }
        });

        if (permissionCheck(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})) {
            return;
        }
        permissionCheckListener.permissionCheckFinish();

    }

    //앨범 이미지 가져오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //갤러리 이미지 가져오기
        if (data == null) {   // 어떤 이미지도 선택하지 않은 경우
            Toast.makeText(getApplicationContext(), "이미지를 선택하지 않았습니다.", Toast.LENGTH_LONG).show();
        } else {   // 이미지를 하나라도 선택한 경우
            if (data.getClipData() == null) {     // 이미지를 하나만 선택한 경우
                Log.e("single choice: ", String.valueOf(data.getData()));
                Uri imageUri = data.getData();
                uriList.add(imageUri);

                adapter = new UriImageAdapter(uriList, getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
            } else {      // 이미지를 여러장 선택한 경우
                ClipData clipData = data.getClipData();
                Log.e("clipData", String.valueOf(clipData.getItemCount()));

                if (clipData.getItemCount() > 10) {   // 선택한 이미지가 11장 이상인 경우
                    Toast.makeText(getApplicationContext(), "사진은 10장까지 선택 가능합니다.", Toast.LENGTH_LONG).show();
                } else {   // 선택한 이미지가 1장 이상 10장 이하인 경우

                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        Uri imageUri = clipData.getItemAt(i).getUri();  // 선택한 이미지들의 uri를 가져온다.
                        try {
                            uriList.add(imageUri);  //uri를 list에 담는다.

                        } catch (Exception e) {

                        }
                    }
                    adapter = new UriImageAdapter(uriList, getApplicationContext());
                    recyclerView.setAdapter(adapter);   // 리사이클러뷰에 어댑터 세팅
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));     // 리사이클러뷰 수평 스크롤 적용
                }
            }
        }
    } //end of onActivityResult

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                //툴바의 아이콘이 할 기능 정의할 것
                Intent intent = new Intent(getApplicationContext(), ReviewPostActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    Callback cbMallDetail = new Callback<MallDetailData>() {
        private final static String TAG = "Retrofit_MallDetail";
        String cbTAG = "레트로핏 - cbMallDetail()";

        @Override
        public void onResponse(Call<MallDetailData> call, Response<MallDetailData> response) {
            if (response.isSuccessful()) {
                MallDetailData mallDetailData = response.body();

                //식당 이름, 식당 위치, 식당 종류 설정
                mallTitle.setText(mallDetailData.getMall_name());
                mallName.setText(mallDetailData.getMall_name());
                mallCategory.setText(mallDetailData.getCategory_name());
                mallLocated.setText(mallDetailData.getGate_location());

                Log.d(cbTAG, mallDetailData.getMall_id().toString());

                //Review 프래그먼트로 식당 id 정보를 넘긴다
                Bundle toReviewFragBundle = new Bundle();
                toReviewFragBundle.putInt("mall_id", mallDetailData.getMall_id());
                review_fragment.setArguments(toReviewFragBundle);


                //Location 프래그먼트로 위도, 경도를 넘긴다
                Bundle toLocationFragBundle = new Bundle();
                toLocationFragBundle.putDouble("latitude", mallDetailData.getLatitude());
                toLocationFragBundle.putDouble("longitude", mallDetailData.getLongitude());
                toLocationFragBundle.putString("mallName", mallDetailData.getMall_name());
                location_fragment.setArguments(toLocationFragBundle);

                //사진 개수가 몇 개인지 확인
                //Log.d(cbTAG, String.valueOf(mallDetailData.getFile_folder().getFiles().size()));


                //메뉴 목록을 담는 arrayList
                ArrayList<MenuData> menus = new ArrayList();

                //메뉴 목록이 0이 아니면 getMenus()로 메뉴 목록을 가져온다
                if (mallDetailData.getMenus() != null) {
                    menus = mallDetailData.getMenus();
                    Log.d("Retrofit", String.valueOf(menus));
                }

                //Menu 프래그먼트로 메뉴 정보를 넘긴다
                Bundle toMenuFragBundle = new Bundle();
                toMenuFragBundle.putParcelableArrayList("mall_menus", menus);
                menu_fragment.setArguments(toMenuFragBundle);

                getSupportFragmentManager().beginTransaction().add(R.id.frame, review_fragment).commit();

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getApplicationContext(), "식당 상세 정보 불러오기 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<MallDetailData> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) "+ t);
        }
    };


    //권한 허가 코드
    public interface PermissionCheckListener {
        void permissionCheckFinish();
    }

    public PermissionCheckListener permissionCheckListener;

    public void setPermissionCheckListener(PermissionCheckListener permissionCheckListener) {
        this.permissionCheckListener = permissionCheckListener;
    }

    public boolean permissionCheck(String[] strings) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < strings.length; i++) {
                if (ContextCompat.checkSelfPermission(this, strings[i]) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(this, strings, 1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            //퍼미션 체크.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] == 0) {
                        if (grantResults.length == (i + 1)) {
                            permissionCheckListener.permissionCheckFinish();
                        }
                    } else {
                        // 거부한 이력이 있으면 true를 반환한다.
                        if (shouldShowRequestPermissionRationale(permissions[i])) {
                            ActivityCompat.requestPermissions(this, permissions, 1);
                            break;
                        } else {
                            new AlertDialog.Builder(this)
                                    .setTitle("다시보지않기 클릭.")
                                    .setMessage(permissions[i] + " 권한이 거부되었습니다 설정에서 직접 권한을 허용 해주세요.")
                                    .setNeutralButton("설정", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                            intent.setData(Uri.parse("package:" + getPackageName()));
                                            startActivity(intent);
                                            Toast.makeText(getApplicationContext(), "권한 설정 후 다시 실행 해주세요.", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    })
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(getApplicationContext(), "권한 설정을 하셔야 앱을 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    })
                                    .setCancelable(false)
                                    .create().show();
                        }// shouldShowRequestPermissionRationale /else
                    } // 권한 거절
                } // for end
            }//Build.VERSION.SDK_INT  end
        }//requestCode  end
    }

} //end of Activity



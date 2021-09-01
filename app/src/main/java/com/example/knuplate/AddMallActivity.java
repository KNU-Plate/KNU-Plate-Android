package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.knuplate.adapter.ResultAdapter;
import com.example.knuplate.data.search.ResultData;
import com.example.knuplate.data.search.SearchData;
import com.example.knuplate.network.RetrofitClient;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMallActivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ResultAdapter resultAdapter;
    MapView resultMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mall);

        searchView = (SearchView) findViewById(R.id.sv_mall);

        recyclerView = findViewById(R.id.rv_search_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        resultAdapter = new ResultAdapter();
        recyclerView.setAdapter(resultAdapter);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.ml_search_mall_map);
        resultMapView = new MapView(this);
        mapViewContainer.addView(resultMapView);

        setListener();
    }

    void setListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("keyword", query);
                RetrofitClient.request(cbSearchResult, "call_search", hashMap);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }


    Callback cbSearchResult = new Callback<SearchData>() {
        private final static String TAG = "Retrofit_MallList";
        String cbTAG = "레트로핏 - cbSearchResult()";

        @Override
        public void onResponse(Call<SearchData> call, Response<SearchData> response) {
            if (response.isSuccessful()) {
                SearchData searchData = response.body();

                resultAdapter.clearItem();
                Log.d("search", searchData.toString());

                for(int i=0; i< searchData.getResult().size(); i++){
                    resultAdapter.addItem(searchData.getResult().get(i));
                }

                resultAdapter.notifyDataSetChanged();

                resultAdapter.setOnItemClickListener((v, pos) -> {
                    ResultData result = searchData.getResult().get(pos);
                    Double latitude = Double.parseDouble(result.getY());
                    Double longitude = Double.parseDouble(result.getX());

                    resultMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), false);
                    MapPOIItem marker = new MapPOIItem();

                    marker.setItemName(result.getPlace_name());
                    marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
                    marker.setTag(0);
                    marker.setShowDisclosureButtonOnCalloutBalloon(false);

                    resultMapView.addPOIItem(marker);

                });

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
            }
        }

        @Override
        public void onFailure(Call<SearchData> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + t);
        }
    };

}
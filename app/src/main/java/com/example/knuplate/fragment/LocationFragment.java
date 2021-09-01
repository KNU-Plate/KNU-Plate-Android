package com.example.knuplate.fragment;

import  android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.knuplate.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class LocationFragment extends Fragment {
    double latitude;
    double longitude;
    String mallName;
    public static LocationFragment newInstance() {
        return new LocationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);

        latitude = getArguments().getDouble("latitude");
        longitude = getArguments().getDouble("longitude");
        mallName = getArguments().getString("mallName");

        Log.d("retrofit", String.valueOf(latitude));
        Log.d("retrofit", String.valueOf(longitude));

        ViewGroup mapViewContainer = v.findViewById(R.id.map_view);
        MapView mapView = new MapView(getActivity());


        //지도 중심점을 변경
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude,longitude), false);

        //식당 마커 추가
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName(mallName);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
        marker.setTag(0);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker.setShowDisclosureButtonOnCalloutBalloon(false);

        mapView.addPOIItem(marker);

        mapViewContainer.addView(mapView);
        return v;
    }

}
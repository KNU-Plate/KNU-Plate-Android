package com.example.knuplate.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.Adapter.MenuAdapter;
import com.example.knuplate.R;
import com.example.knuplate.model.dto.MenuData;

import java.util.ArrayList;

public class Fragment_Menu extends Fragment {

    ArrayList<MenuData> menus;
    RecyclerView menuRecyclerView;
    MenuAdapter menuAdapter;

    public static Fragment_Menu newInstance() {
        return new Fragment_Menu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        //DetailActivity에게 받아옴
        menus = getArguments().getParcelableArrayList("mall_menus");

        menuRecyclerView = v.findViewById(R.id.recyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        menuAdapter = new MenuAdapter();
        menuRecyclerView.setAdapter(menuAdapter);

        Log.d("Retrofit", String.valueOf(menus.size()));
        //메뉴 목록 추가
        for (int i = 0; i< menus.size(); i++){
            Log.d("Retrofit", menus.get(i).toString());
            menuAdapter.addItem(menus.get(i));
        }

        //데이터 변화했음을 알림
        menuAdapter.notifyDataSetChanged();

        return v;

    }
}
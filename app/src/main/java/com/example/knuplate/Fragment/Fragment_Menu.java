package com.example.knuplate.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.Adapter.MenuAdapter;
import com.example.knuplate.Adapter.ReviewAdapter;
import com.example.knuplate.R;
import com.example.knuplate.model.dto.MenuData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fragment_Menu extends Fragment {

    ArrayList<MenuData> menuDataList;
    RecyclerView menuRecyclerView;
    MenuAdapter menuAdapter;

    public static Fragment_Menu newInstance() {
        return new Fragment_Menu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        menuDataList = getArguments().getParcelableArrayList("mall_menu");

        menuRecyclerView = v.findViewById(R.id.recyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //test
<<<<<<< HEAD
=======
        ArrayList<MenuData> arrayList = new ArrayList<>();
        MenuAdapter menuAdapter = new MenuAdapter(arrayList);
        recyclerView.setAdapter(menuAdapter);

        MenuData testdata1 = new MenuData("TestData1", 100);
        MenuData testdata2 = new MenuData("TestData2", 20);
        MenuData testdata3 = new MenuData("TestData3", 38);
        arrayList.add(testdata1);
        arrayList.add(testdata2);
        arrayList.add(testdata3);
        arrayList.add(testdata2);
        arrayList.add(testdata1);
        arrayList.add(testdata2);
        arrayList.add(testdata3);
>>>>>>> ba5ddfcdb1fca974621ab6c9f33bbf6a313c4ca1

        menuAdapter = new MenuAdapter();
        menuRecyclerView.setAdapter(menuAdapter);

        //메뉴 목록 추가
        for (int i=0; i<menuDataList.size(); i++){
            menuAdapter.addItem(menuDataList.get(i));
        }

        //데이터 변화했음을 알림
        menuAdapter.notifyDataSetChanged();

        return v;

    }
}
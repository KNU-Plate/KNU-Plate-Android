package com.example.knuplate.Adapter;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.knuplate.Fragment.RestListFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestListAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> items; //프래그먼트 담는 리스트

    public RestListAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        items = new ArrayList<Fragment>();

        //카테고리 이름 리스트
        final List<String> tabElement = Arrays.asList("한식", "중식", "일식", "세계 음식", "카페", "양식", "술집");

        for (int i=0; i<tabElement.size(); i++){
            RestListFragment restListFragment = new RestListFragment();

            Bundle bundle = new Bundle(1);
            bundle.putString("category_name", tabElement.get(i));

            restListFragment.setArguments(bundle); //카테고리 이름 값 넘기기

            items.add(restListFragment);
        }


    }


    @Override
    public Fragment createFragment(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}

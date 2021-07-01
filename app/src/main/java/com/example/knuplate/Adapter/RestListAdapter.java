package com.example.knuplate.Adapter;

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

public class RestListAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> items; //프래그먼트 담는 리스트

    public RestListAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        items = new ArrayList<Fragment>();

        items.add(new RestListFragment("korean_food"));
        items.add(new RestListFragment("chinese_food"));
        items.add(new RestListFragment("japanese_food"));
        items.add(new RestListFragment("세계 음식"));
        items.add(new RestListFragment("카페"));
        items.add(new RestListFragment("양식"));
        items.add(new RestListFragment("술집"));

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

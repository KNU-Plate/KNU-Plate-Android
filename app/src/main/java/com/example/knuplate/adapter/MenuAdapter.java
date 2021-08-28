package com.example.knuplate.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.R;
import com.example.knuplate.data.mall.MenuData;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private ArrayList<MenuData> menuDataList = new ArrayList<>();

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuViewHolder holder = new  MenuViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.menu_item_tv.setText(menuDataList.get(position).getMenu_name());

        //좋아요 비율 계산
        Integer cntOfLike = menuDataList.get(position).getLike(); //좋아요 개수
        Integer cntOfDislike = menuDataList.get(position).getDislike(); //싫어요 개수
        int sum = cntOfLike + cntOfDislike; //좋아요 개수+ 싫어요 개수

        //double ratioOfLike = cntOfLike / (cntOfDislike+cntOfLike) *100; //비율 게산한건데 필요 없는 듯

        holder.menu_item_pb.setProgress(cntOfLike); //progress를 like의 개수로 지정
        holder.menu_item_pb.setMax(sum); //최대 크기를 sum으로 지정
    }

    @Override
    public int getItemCount(){
        return menuDataList.size();
    }

    public void addItem(MenuData menuData){
        menuDataList.add(menuData);
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView menu_item_tv;
        ProgressBar menu_item_pb;

        public MenuViewHolder(@NonNull final View itemView) {
            super(itemView);

            this.menu_item_tv = itemView.findViewById(R.id.menu_item_tv);
            this.menu_item_pb = itemView.findViewById(R.id.menu_item_pb);
        }
    }

}

package com.example.knuplate.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.R;
import com.example.knuplate.model.ReviewData;
import com.example.knuplate.model.dto.MenuData;

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
        Integer cntOfLike = menuDataList.get(position).getLike();
        Integer cntOfDislike = menuDataList.get(position).getDislike();
        Integer ratioOfLike = cntOfLike / (cntOfDislike+cntOfLike) *100 ;

        holder.menu_item_pb.setProgress(ratioOfLike);

    }


    @Override
    public int getItemCount(){
    // 삼항 연산자
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

package com.example.knuplate.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.R;
import com.example.knuplate.model.ReviewDataTest;

import java.util.ArrayList;

public class ReviewAdapterTest extends RecyclerView.Adapter<ReviewAdapterTest.ReviewViewHolder>{
    private ArrayList<ReviewDataTest> arrayList;

    public ReviewAdapterTest(ArrayList<ReviewDataTest> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        ReviewViewHolder holder = new ReviewViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.detail_picture.setImageResource(arrayList.get(position).getDetail_picture());
        holder.detail_nick.setText(arrayList.get(position).getDetail_nick());
        holder.detail_profile.setImageResource(arrayList.get(position).getDetail_profile());
        holder.detail_rate.setRating(arrayList.get(position).getDetail_rate());
        holder.detail_review.setText(arrayList.get(position).getDetail_review());
    }


    @Override
    public int getItemCount(){
    // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }


    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        ImageView detail_picture;
        RatingBar detail_rate;
        TextView detail_nick;
        ImageView detail_profile;
        TextView detail_review;

        public ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);

            this.detail_picture = itemView.findViewById(R.id.detail_picture);
            this.detail_rate = itemView.findViewById(R.id.detail_rate);
            this.detail_nick = itemView.findViewById(R.id.detail_nick);
            this.detail_profile = itemView.findViewById(R.id.detail_profile);
            this.detail_review = itemView.findViewById(R.id.detail_review);
        }
    }

}

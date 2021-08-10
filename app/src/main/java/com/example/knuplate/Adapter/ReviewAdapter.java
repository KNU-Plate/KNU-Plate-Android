package com.example.knuplate.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.knuplate.DetailActivity;
import com.example.knuplate.DetailZoomActivity;
import com.example.knuplate.R;
import com.example.knuplate.model.MallData;
import com.example.knuplate.model.ReviewData;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{
    private ArrayList<ReviewData> reviewDataList = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        ReviewViewHolder holder = new ReviewViewHolder(view);
        context = parent.getContext();
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        //holder.detail_picture.setImageResource(arrayList.get(position).getReview_id());

        Glide.with(holder.itemView.getContext())
                .load(R.drawable.testpicture)
                .into(holder.detail_picture);

        holder.detail_nick.setText(reviewDataList.get(position).getUser_id());

        //holder.detail_profile.setImageResource(arrayList.get(position).getDetail_profile());
        holder.detail_rate.setRating(reviewDataList.get(position).getEvaluate());
        holder.detail_review.setText(reviewDataList.get(position).getContents());
    }

    @Override
    public int getItemCount() {
        return reviewDataList.size();
    }

    public void addItem(ReviewData reviewData){
        reviewDataList.add(reviewData);
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        ImageView detail_picture;
        RatingBar detail_rate;
        TextView detail_nick;
        ImageView detail_profile;
        TextView detail_review;

        public ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);

            // 아이템 클릭 이벤트 처리.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : process click event.
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        //RecyclerItem item = reviewDataList.get(pos) ;
                        Intent intent = new Intent(context, DetailZoomActivity.class);
                        context.startActivity(intent);

                    }
                }
            });

            this.detail_picture = itemView.findViewById(R.id.detail_picture);
            this.detail_rate = itemView.findViewById(R.id.detail_rate);
            this.detail_nick = itemView.findViewById(R.id.detail_nick);
            this.detail_profile = itemView.findViewById(R.id.detail_profile);
            this.detail_review = itemView.findViewById(R.id.detail_review);
        }
    }

}

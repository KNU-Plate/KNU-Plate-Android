package com.example.knuplate.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.knuplate.R;
import com.example.knuplate.model.MallData;
import com.example.knuplate.model.ReviewData;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{
    private ArrayList<ReviewData> reviewDataList = new ArrayList<>();

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        ReviewViewHolder holder = new ReviewViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        //holder.detail_picture.setImageResource(arrayList.get(position).getReview_id());

        holder.detail_nick.setText(reviewDataList.get(position).getUser_id());

        holder.detail_rate.setRating(reviewDataList.get(position).getEvaluate());
        holder.detail_review.setText(reviewDataList.get(position).getContents());

        holder.onBind(reviewDataList.get(position));
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

            this.detail_picture = itemView.findViewById(R.id.detail_picture);
            this.detail_rate = itemView.findViewById(R.id.detail_rate);
            this.detail_nick = itemView.findViewById(R.id.detail_nick);
            this.detail_profile = itemView.findViewById(R.id.detail_profile);
            this.detail_review = itemView.findViewById(R.id.detail_review);
        }

        void onBind(ReviewData data){

            //파일 폴더가 null이 아니고 사진이 1개 이상이면
            if (data.getFile_folder() != null && data.getFile_folder().getFiles().size() > 0){
                //사진을 넣도록 한다

                //(참고) 첫 번째 인덱스의 사진 경로
                // data.getFile_folder().getFiles().get(0).getPath()
                Glide.with(detail_picture.getContext()).load(data.getFile_folder().getFiles().get(0).getPath()).into(detail_picture);
            }

        }


    }

}

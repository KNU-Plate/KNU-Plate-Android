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
import com.example.knuplate.model.NoticeData;
import com.example.knuplate.model.ReviewData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>{
    private ArrayList<NoticeData> noticeList;

    public NoticeAdapter(ArrayList<NoticeData> noticeList) {
        this.noticeList = noticeList;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, parent, false);
        NoticeViewHolder holder = new NoticeViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        //holder.detail_picture.setImageResource(arrayList.get(position).getReview_id());
        holder.tv_notice_title.setText(noticeList.get(position).getTitle());
        holder.tv_notice_contents.setText(noticeList.get(position).getContents());

        //timestamp -> formatString
        Date date = new Date(noticeList.get(position).getDate_create());
        SimpleDateFormat datef = new SimpleDateFormat("yyyy / MM / dd", Locale.getDefault());
        holder.tv_notice_date.setText(datef.format(date));
    }


    @Override
    public int getItemCount(){
    // 삼항 연산자
        return (noticeList != null ? noticeList.size() : 0);
    }


    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        TextView tv_notice_title;
        TextView tv_notice_contents;
        TextView tv_notice_date;


        public NoticeViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.tv_notice_title = itemView.findViewById(R.id.tv_notice_title);
            this.tv_notice_contents = itemView.findViewById(R.id.tv_notice_contents);
            this.tv_notice_date = itemView.findViewById(R.id.tv_notice_date);
        }
    }

}

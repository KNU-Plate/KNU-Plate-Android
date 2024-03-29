package com.example.knuplate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.knuplate.R;
import com.example.knuplate.data.mall.MallData;

import java.util.ArrayList;

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.RestItemViewHolder> {

    private ArrayList<MallData> list = new ArrayList<>();
    private OnItemClickListener mListener = null; //리스너 객체 참조를 저장

    @NonNull
    @Override
    public RestItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //item_restaurant를 inflate 시킴
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RestItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestItemViewHolder holder, int position) {

        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(MallData mallData) {
        list.add(mallData);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public interface OnItemClickListener { //커스텀 리스너 인터페이스
        void onItemClick(View v, int pos);
    }

    class RestItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tv_name;
        private TextView tv_rating;

        public RestItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.restImage);
            tv_name = itemView.findViewById(R.id.tv_restName);
            tv_rating = itemView.findViewById(R.id.tv_rating);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition(); //어댑터 내 아이템의 위치 리턴
                if (position != RecyclerView.NO_POSITION) {
                    // TODO : use pos.
                    //MallData mallData = list.get(position);

                    if (mListener != null) {
                        mListener.onItemClick(v, position);
                    }

                }
            });
        }

        void onBind(MallData data) {

            //파일 폴더가 null이 아니고 사진이 1개 이상이면
            if (data.getFile_folder() != null && data.getFile_folder().getFiles().size() > 0) {
                //사진을 넣도록 한다

                Glide.with(imageView.getContext()).load(data.getFile_folder().getFiles().get(0).getPath()).into(imageView);
            }

            tv_name.setText(data.getMall_name());
            tv_name.setSelected(true);

            if (data.getEvaluate_average() != null) {
                tv_rating.setText(data.getEvaluate_average().toString());
            }

        }
    }
}

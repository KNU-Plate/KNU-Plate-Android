package com.example.knuplate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.R;
import com.example.knuplate.model.MallData;

import java.util.ArrayList;

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.RestItemViewHolder> {

    private ArrayList<MallData> list=new ArrayList<>();
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

    public void addItem(MallData mallData){
        list.add(mallData);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }


    public interface OnItemClickListener{ //커스텀 리스너 인터페이스
        void onItemClick(View v, int pos);
    }

    class RestItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView tv_name;
        private TextView tv_rating;

        public RestItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.restImage);
            tv_name = itemView.findViewById(R.id.tv_restName);
            tv_rating = itemView.findViewById(R.id.tv_rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); //어댑터 내 아이템의 위치 리턴
                    if (position != RecyclerView.NO_POSITION) {
                        // TODO : use pos.
                        //MallData mallData = list.get(position);

                        if(mListener != null){
                            mListener.onItemClick(v, position);
                        }

                    }
                }
            });
        }

        void onBind(MallData data){

            //imageView.setImageBitmap(data.getThumbnail());
            tv_name.setText(data.getMall_name());

            if (data.getEvaluate_average() != null){
                tv_rating.setText(data.getEvaluate_average().toString());
            }

        }
    }
}

package com.example.knuplate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knuplate.R;
import com.example.knuplate.data.mall.MallData;
import com.example.knuplate.data.search.ResultData;
import com.example.knuplate.data.search.SearchData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ItemViewHolder> {
    private OnItemClickListener mListener = null;
    private ArrayList<ResultData> resultList = new ArrayList<ResultData>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new ResultAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(resultList.get(position));
    }

    public void addItem(ResultData resultData) {
        resultList.add(resultData);
    }

    public void clearItem(){
        resultList.clear();
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView resultTitle;
        private TextView resultAddress;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            resultTitle = itemView.findViewById(R.id.tv_result_title);
            resultAddress = itemView.findViewById(R.id.tv_result_address);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();

                if (pos != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(v, pos);
                }
            });
        }

        void onBind(ResultData resultData) {
            resultTitle.setText(resultData.getPlace_name());
            resultAddress.setText(resultData.getRoad_address_name()); //도로명 주소
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}

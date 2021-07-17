package com.example.knuplate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.knuplate.R;
import com.example.knuplate.model.NoticeData;

import java.util.List;


public class NoticeAdapter extends BaseAdapter {

    private Context mContext;
    private List<NoticeData> array_list;
    private ViewHolder mViewHolder;

    public NoticeAdapter(Context mContext, List<NoticeData> array_mountain) {
        this.mContext = mContext;
        this.array_list = array_mountain;

    }


    @Override

    public int getCount() {
        return array_list.size();
    }


    @Override

    public Object getItem(int position) {
        return array_list.get(position);
    }


    @Override

    public long getItemId(int position) {
        return position;
    }


    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHoldr 패턴

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_notice, parent, false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        // View에 Data 세팅
        mViewHolder.tv_notice_contents.setText(array_list.get(position).getContents());
        mViewHolder.tv_notice_title.setText(array_list.get(position).getTitle());
        return convertView;
    }


    public class ViewHolder {
        private TextView tv_notice_contents;
        private TextView tv_notice_title;
        public ViewHolder(View convertView) {
            tv_notice_contents = (TextView) convertView.findViewById(R.id.tv_notice_contents);
            tv_notice_title = (TextView) convertView.findViewById(R.id.tv_notice_title);
        }
    }

}
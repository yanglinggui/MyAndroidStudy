package com.yanglinggui.myandroidstudy.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanglinggui.myandroidstudy.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    private Context mContext;
    private List<RecyclerViewBean> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<RecyclerViewBean> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        /*这里也可以设置分割线
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 1;
        view.setLayoutParams(layoutParams);*/

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        holder.imageView.setImageResource(mData.get(position).getImageId());
        holder.textView.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public RecyclerViewBean getItemBean(int position) {
        return mData.get(position);
    }
}

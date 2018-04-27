package com.yanglinggui.myandroidstudy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private String[] mData;

    public RecyclerViewAdapter(Context context, String[] data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        /*这里也可以设置分割线
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 1;
        view.setLayoutParams(layoutParams);*/
        RecyclerViewHolder mHolderView = new RecyclerViewHolder(view);
        return mHolderView;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(R.mipmap.ic_launcher);
        holder.textView.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}

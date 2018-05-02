package com.yanglinggui.myandroidstudy.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yanglinggui.myandroidstudy.R;

public class LoadMoreViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public LoadMoreViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.loadmore);
    }
}

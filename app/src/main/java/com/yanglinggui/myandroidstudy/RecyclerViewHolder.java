package com.yanglinggui.myandroidstudy;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView textView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.tv);
    }
}

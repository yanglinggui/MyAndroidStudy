package com.yanglinggui.myandroidstudy.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanglinggui.myandroidstudy.R;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public RecyclerHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.tv);
    }
}

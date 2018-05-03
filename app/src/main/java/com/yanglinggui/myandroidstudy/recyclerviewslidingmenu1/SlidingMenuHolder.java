package com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanglinggui.myandroidstudy.R;

public class SlidingMenuHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView item, menu;

    public SlidingMenuHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        item = itemView.findViewById(R.id.title);
        menu = itemView.findViewById(R.id.menu);
    }
}

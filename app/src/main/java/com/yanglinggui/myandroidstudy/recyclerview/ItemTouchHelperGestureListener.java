package com.yanglinggui.myandroidstudy.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

    private RecyclerView recyclerView;
    private RecyclerOnItemTouchListener mListener;

    public ItemTouchHelperGestureListener(RecyclerOnItemTouchListener listener, RecyclerView view) {
        recyclerView = view;
        mListener = listener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            int position = recyclerView.indexOfChild(child);
            mListener.onItemClick(recyclerView.getChildViewHolder(child), position);
        }
        return super.onSingleTapUp(e);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //super.onLongPress(e);
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            int position = recyclerView.indexOfChild(child);
            mListener.onLongPress(recyclerView.getChildViewHolder(child), position);
        }
    }
}

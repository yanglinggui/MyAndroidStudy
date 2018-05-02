package com.yanglinggui.myandroidstudy.recyclerview;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

public abstract class RecyclerOnItemTouchListener implements RecyclerView.OnItemTouchListener {

    private RecyclerView recyclerView;
    private GestureDetectorCompat mGestureDetectorCompat;

    public RecyclerOnItemTouchListener(RecyclerView view) {
        recyclerView = view;
        mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new
                ItemTouchHelperGestureListener(RecyclerOnItemTouchListener.this,recyclerView));
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public abstract void onItemClick(RecyclerView.ViewHolder holder, int position);

    public abstract void onLongPress(RecyclerView.ViewHolder holder, int position);
}

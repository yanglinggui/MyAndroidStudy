package com.yanglinggui.myandroidstudy;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewDividerItemDecoration extends RecyclerView.ItemDecoration {

    public RecyclerViewDividerItemDecoration() {
        super();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        android.util.Log.i("qiao-yang","RecyclerViewDividerItemDecoration --->  onDraw");
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        android.util.Log.i("qiao-yang","RecyclerViewDividerItemDecoration --->  onDrawOver");
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        android.util.Log.i("qiao-yang","RecyclerViewDividerItemDecoration --->  getItemOffsets");
    }
}

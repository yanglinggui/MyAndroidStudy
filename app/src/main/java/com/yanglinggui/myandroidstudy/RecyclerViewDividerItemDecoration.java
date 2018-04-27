package com.yanglinggui.myandroidstudy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;

public class RecyclerViewDividerItemDecoration extends RecyclerView.ItemDecoration {


    private float divderTopHeight = 0;
    private float divderBottomHeight = 0;
    private float divderleftHeight = 0;
    private float divderRightHeight = 0;
    private Paint mPaint;

    public RecyclerViewDividerItemDecoration() {
        super();
        mPaint = new Paint();
        mPaint.setAntiAlias(false);
        mPaint.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        android.util.Log.i("qiao-yang", "RecyclerViewDividerItemDecoration --->  onDraw");
        int count = parent.getChildCount();
        View v;
        float dividerTop, dividerBottom, dividerLeft, dividerRight;
        for (int i = 0; i < count; i++) {
            v = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(v);
            mPaint.setAntiAlias(false);
            mPaint.setColor(Color.RED);
            //绘制分割线
            dividerTop = v.getTop() - divderTopHeight;
            dividerBottom = v.getTop();
            dividerLeft = parent.getPaddingLeft();
            dividerRight = parent.getWidth() - parent.getPaddingRight() - divderRightHeight;
            if (position % 3 != 0) {
                c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
                //dividerTop = v.getTop() - 30;//divderTopHeight;; //绘制右侧图案
            } else {
                dividerTop = v.getTop() - 100;//divderTopHeight; //绘制右侧图案
                //c.drawRect(dividerLeft, dividerTop, dividerRight + divderRightHeight, dividerBottom, mPaint);
                TextPaint mTextPaint = new TextPaint();
                mTextPaint.setColor(Color.GREEN); // 设置paint颜色
                mTextPaint.setTextSize(100);       // 设置字体大小DP
                mTextPaint.setAntiAlias(true);       // 设置抗锯齿
                mTextPaint.setTextAlign(Paint.Align.CENTER); // 设置字体居中
                c.drawText("sss"+position,dividerLeft+300,dividerTop+95,mTextPaint);
            }
            //绘制右侧图案
            //dividerTop = v.getTop() - divderTopHeight;;
            dividerBottom = v.getBottom();
            dividerLeft = dividerRight;
            dividerRight = dividerLeft + divderRightHeight;
            //c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
            //绘画竖线
            mPaint.setStrokeWidth(5);//竖线加粗
            c.drawLine(dividerLeft + divderRightHeight / 2, dividerTop, dividerRight - divderRightHeight / 2, dividerBottom, mPaint);

            //绘制圆形
            mPaint.setStyle(Paint.Style.STROKE);
            c.drawCircle(dividerLeft + divderRightHeight / 2, v.getTop() + v.getHeight() / 2, divderRightHeight / 2, mPaint);
            mPaint.reset();
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        android.util.Log.i("qiao-yang", "RecyclerViewDividerItemDecoration --->  onDrawOver");
        int count = parent.getChildCount();
        View v;
        for (int i = 0; i < count; i++) {
            v = parent.getChildAt(i);
            //绘制圆形在View上方
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setAntiAlias(false);
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.STROKE);
            c.drawCircle(v.getLeft() + v.getWidth() / 2, v.getTop() + v.getHeight() / 2, v.getHeight() / 2, mPaint);
            mPaint.reset();
            //int position = parent.getChildAdapterPosition(v);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        android.util.Log.i("qiao-yang", "RecyclerViewDividerItemDecoration --->  getItemOffsets");
        int position = parent.getChildAdapterPosition(view);
        if (position % 3 == 0) {
            outRect.top = 100;
        } else {
            outRect.top = 30;
        }
        divderTopHeight = outRect.top;
        outRect.right = 80;
        divderRightHeight = outRect.right;
    }
}

package com.yanglinggui.myandroidstudy.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOffsetRight;
    private int mOffsetTopHead;
    private int mOffsetTopItem;
    private Paint mPaint;
    private TextPaint textPaint;
    private CallBack callBack;

    public RecyclerItemDecoration(CallBack callBack) {
        super();
        mOffsetRight = 100;
        mOffsetTopHead = 100;
        mOffsetTopItem = 20;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);

        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK); // 设置paint颜色
        textPaint.setTextSize(100);       // 设置字体大小DP
        textPaint.setAntiAlias(true);       // 设置抗锯齿
        textPaint.setTextAlign(Paint.Align.LEFT); // 设置字体居中
        this.callBack = callBack;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        /*android.util.Log.i("qiao-yang", "parent.getPaddingLeft() = " + parent.getPaddingLeft() +
                " parent.getLeft() = " + parent.getLeft() +
                " parent.getWidth() = " + parent.getWidth() +
                " parent.getPaddingRight() = " + parent.getPaddingRight() +
                " parent.getRight() = " + parent.getRight());*/

        float left;
        float top;
        float right;
        float bottom;

        left = parent.getPaddingLeft();
        right = parent.getWidth() - mOffsetRight;
        View view;
        for (int i = 0; i < parent.getChildCount(); i++) {
            view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            bottom = view.getTop();
            top = bottom - mOffsetTopItem;
            if (null != callBack && callBack.getItemBean(position).isFirest()) {
                top = bottom - mOffsetTopHead;
                mPaint.setColor(Color.YELLOW);
                //mPaint.setStyle(Paint.Style.STROKE);
                c.drawRect(left, top, right, bottom, mPaint);
                c.drawText("" + callBack.getItemBean(position).getGroupId(), left, bottom - 10, textPaint);
            } else {
                mPaint.setColor(Color.GRAY);
                c.drawRect(left, top, right, bottom, mPaint);
            }
            mPaint.setColor(Color.RED);
            c.drawLine(right + mOffsetRight / 2, top, right + mOffsetRight / 2, view.getBottom(), mPaint);
            c.drawCircle(right + mOffsetRight / 2, bottom + view.getHeight() / 2, mOffsetRight / 2, mPaint);
            //mPaint.reset();
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        float left;
        float top;
        float right;
        float bottom;
        left = parent.getPaddingLeft();
        right = parent.getWidth() - mOffsetRight;
        View view;
        for (int i = 0; i < parent.getChildCount(); i++) {
            view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            top = parent.getPaddingTop();
            if (null != callBack && i == 0) {
                if (callBack.getItemBean(position).isLast() && view.getBottom() - mOffsetTopHead < top) {
                    top = view.getBottom() - mOffsetTopHead;
                }
                bottom = top + mOffsetTopHead;
                mPaint.setColor(Color.YELLOW);
                //mPaint.setStyle(Paint.Style.STROKE);
                c.drawRect(left, top, right, bottom, mPaint);
                c.drawText("" + callBack.getItemBean(position).getGroupId(), left, bottom - 10, textPaint);
            }
            mPaint.setColor(Color.RED);
            c.drawCircle(left + view.getWidth() / 2, view.getBottom() - view.getHeight() / 2, view.getHeight() / 2,
                    mPaint);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
            state) {
        super.getItemOffsets(outRect, view, parent, state);
        /*if (null != callBack) {
            int position = parent.getChildAdapterPosition(view);
            RecyclerViewBean mItem = callBack.getItemBean(position);
            if (mItem.isFirest()) {
                outRect.top = mOffsetTopHead;
            } else {
                outRect.top = mOffsetTopItem;
            }
            outRect.right = mOffsetRight;
        }*/
        outRect.right = mOffsetRight;
        outRect.top = mOffsetTopItem;
        if (null != callBack) {
            int position = parent.getChildAdapterPosition(view);
            RecyclerViewBean mItem = callBack.getItemBean(position);
            if (mItem.isFirest()) {
                outRect.top = mOffsetTopHead;
            }
        }
    }

    public interface CallBack {
        RecyclerViewBean getItemBean(int position);
    }
}

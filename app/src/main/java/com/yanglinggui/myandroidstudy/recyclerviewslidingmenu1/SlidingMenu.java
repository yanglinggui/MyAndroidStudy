package com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView {

    private static final float radio = 0.3f;
    private boolean once = true;
    private boolean isOpenMenu = false;
    private final int mScreenWidth;
    private final int mMenuWidth;

    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOverScrollMode(View.OVER_SCROLL_NEVER);
        setHorizontalScrollBarEnabled(false);
        mScreenWidth = getScreenWidth(context);
        mMenuWidth = (int) (radio * mScreenWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (once) {
            LinearLayout wrapper = (LinearLayout) getChildAt(0);
            wrapper.getChildAt(0).getLayoutParams().width = mScreenWidth;
            wrapper.getChildAt(1).getLayoutParams().width = mMenuWidth;
            once = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                if (Math.abs(getScaleX()) < mMenuWidth / 2) {
                    smoothScrollTo(0, 0);
                } else {
                    smoothScrollTo(mMenuWidth, 0);
                }
        }
        return super.onTouchEvent(ev);
    }


    private int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
}

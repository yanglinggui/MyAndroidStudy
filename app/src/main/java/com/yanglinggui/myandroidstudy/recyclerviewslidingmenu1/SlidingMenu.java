package com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
        android.util.Log.i("qiao-yang", "onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                closeOpenMenu();
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(getScaleX()) < mMenuWidth / 2) {
                    this.smoothScrollTo(0, 0);
                } else {
                    this.smoothScrollTo(mMenuWidth, 0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }


    public void closeMenu() {
        smoothScrollTo(0, 0);
        isOpenMenu = false;
    }

    public boolean isOpenMenu() {
        return isOpenMenu;
    }

    private void OpenMenu() {
        getAdapter().saveOpenMenu(this);
        isOpenMenu = true;
    }

    private void closeOpenMenu() {
        if (isOpenMenu) {
            getAdapter().closeMenu();
        }
    }

    private SlidingMenuAdapter getAdapter() {
        View view = this;
        while (true) {
            view = (View) view.getParent();
            if (view instanceof RecyclerView) {
                break;
            }
        }
        return (SlidingMenuAdapter) ((RecyclerView) view).getAdapter();
    }

    private int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
}

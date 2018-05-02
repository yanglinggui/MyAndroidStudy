package com.yanglinggui.myandroidstudy.bottomnavigation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.yanglinggui.myandroidstudy.R;

import java.util.ArrayList;
import java.util.List;

//https://www.jianshu.com/p/48e4180e3ae7
public class BottomNavigationBarActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, BottomNavigationBar.OnTabSelectedListener {


    private LinearLayout mLinearLayout;
    private ViewPager mViewPager;
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigation);
        mLinearLayout = findViewById(R.id.main);

        mViewPager = findViewById(R.id.viewpager);
        fragments = new ArrayList();
        fragments.add(new Fragment1());
        fragments.add(new Fragment1());
        fragments.add(new Fragment1());
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        //mViewPager.setOnPageChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setCurrentItem(0);

        mBottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setTabSelectedListener(this);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.
                addItem(new BottomNavigationItem(R.drawable.ic_add_box_black_24dp, "111")
                        .setInactiveIconResource(R.mipmap.ic_launcher)
                        .setActiveColor(Color.YELLOW))
                .addItem(new BottomNavigationItem(R.drawable.ic_add_box_black_24dp, "222")
                        .setInactiveIconResource(R.mipmap.ic_launcher)
                        .setActiveColor(Color.YELLOW))
                .addItem(new BottomNavigationItem(R.drawable.ic_add_box_black_24dp, "333")
                        .setInactiveIconResource(R.mipmap.ic_launcher)
                        .setActiveColor(Color.YELLOW))
                .initialise();


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

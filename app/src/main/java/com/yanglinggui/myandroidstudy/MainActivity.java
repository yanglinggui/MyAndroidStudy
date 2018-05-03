package com.yanglinggui.myandroidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yanglinggui.myandroidstudy.bottomnavigation.BottomNavigationBarActivity;
import com.yanglinggui.myandroidstudy.recyclerview.RecyclerViewActivity;
import com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1.RecyclerViewSlidingMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.okhttp:
                startActivity(new Intent(this, OkHttpTestActivity.class));
                break;
            case R.id.rxjava:
                startActivity(new Intent(this, RxJavaTestActivity.class));
                break;
            case R.id.recyclerview:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.recyclerview_sliding_menu1:
                startActivity(new Intent(this, RecyclerViewSlidingMenuActivity.class));
                break;
            case R.id.bottomnavigationbar:
                startActivity(new Intent(this, BottomNavigationBarActivity.class));
                break;
        }
    }
}

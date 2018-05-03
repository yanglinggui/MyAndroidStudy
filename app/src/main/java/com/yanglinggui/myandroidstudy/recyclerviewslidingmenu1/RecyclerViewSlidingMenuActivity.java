package com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yanglinggui.myandroidstudy.R;
import com.yanglinggui.myandroidstudy.recyclerview.RecyclerViewBean;

import java.util.ArrayList;
import java.util.List;

//https://blog.csdn.net/yhaolpz/article/details/77366154?utm_source=debugrun&utm_medium=referral
public class RecyclerViewSlidingMenuActivity extends Activity {

    private RecyclerView mRecyclerView;
    private SlidingMenuAdapter mAdapter;
    private List<RecyclerViewBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview1);

        mData = new ArrayList();
        RecyclerViewBean m;
        for (int i = 0; i < 25; i++) {
            m = new RecyclerViewBean();
            m.setImageId(R.mipmap.ic_launcher);
            m.setName("" + i);
            m.setGroupId(i / 5);
            m.setFirest(i % 5 == 0);
            m.setLast(i % 5 == 4);
            mData.add(m);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.addOnScrollListener();

        mAdapter = new SlidingMenuAdapter(this, mData);

        mRecyclerView.setAdapter(mAdapter);
    }
}

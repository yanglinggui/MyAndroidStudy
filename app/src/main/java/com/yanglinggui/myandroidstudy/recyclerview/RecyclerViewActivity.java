package com.yanglinggui.myandroidstudy.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yanglinggui.myandroidstudy.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<RecyclerViewBean> mData;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

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
       /* for (int i = 0; i < 25; i++) {
            android.util.Log.i("qiao-yang", "" + i + " isFirest = " + mData.get(i).isFirest() + "" +
                    "  isLast = " + mData.get(i).isLast());
        }*/

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(this, mData);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerItemDecoration(new RecyclerItemDecoration
                .CallBack() {
            @Override
            public RecyclerViewBean getItemBean(int position) {
                return mAdapter.getItemBean(position);
            }
        }));
        mRecyclerView.setAdapter(mAdapter);
    }
}

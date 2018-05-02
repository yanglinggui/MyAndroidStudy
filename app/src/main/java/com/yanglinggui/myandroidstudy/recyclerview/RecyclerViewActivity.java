package com.yanglinggui.myandroidstudy.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.yanglinggui.myandroidstudy.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<RecyclerViewBean> mData;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefresh;

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
        mSwipeRefresh = findViewById(R.id.refresh);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //SystemClock.sleep(3000);
                //mSwipeRefresh.setRefreshing(false);
            }
        });
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(this, mData);
        mRecyclerView.setHasFixedSize(true);
        /*mRecyclerView.addItemDecoration(new RecyclerItemDecoration(new RecyclerItemDecoration
                .CallBack() {
            @Override
            public RecyclerViewBean getItemBean(int position) {
                return mAdapter.getItemBean(position);
            }
        }));*/
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerOnItemTouchListener(mRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, int position) {
                android.util.Log.i("qiao-yang", "onItemClick--->" + position);
                //finish();
            }

            @Override
            public void onLongPress(RecyclerView.ViewHolder holder, int position) {
                android.util.Log.i("qiao-yang", "onLongPress--->" + position);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelperCallback
                (mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView
                        .canScrollVertically(1)) {
                    android.util.Log.i("qiao-yang", "onScrollStateChanged");
                    mAdapter.setFootState(2);
                    mAdapter.notifyItemChanged(mAdapter.getItemCount() - 1);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}

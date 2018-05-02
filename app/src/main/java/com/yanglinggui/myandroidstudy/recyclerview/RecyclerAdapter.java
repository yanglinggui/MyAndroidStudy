package com.yanglinggui.myandroidstudy.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanglinggui.myandroidstudy.R;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<RecyclerViewBean> mData;
    private LayoutInflater mInflater;
    private int normalType = 0, footType = 1;
    private final int loadMore = 0, loading = 1, loadNone = 2;
    private int footState = -1;

    public RecyclerAdapter(Context context, List<RecyclerViewBean> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mData.size()) {
            return footType;
        } else {
            return normalType;
        }
        //return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        /*这里也可以设置分割线
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 1;
        view.setLayoutParams(layoutParams);*/
        android.util.Log.i("qiao-yang", "onCreateViewHolder viewType = " + viewType);
        if (viewType == footType) {
            View view = mInflater.inflate(R.layout.loadmore_recyclerview, parent, false);
            LoadMoreViewHolder loadMoreViewHolder = new LoadMoreViewHolder(view);
            loadMoreViewHolder.itemView.setVisibility(View.INVISIBLE);
            return loadMoreViewHolder;
        } else {
            View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
            return new RecyclerHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerHolder) {
            ((RecyclerHolder) holder).imageView.setImageResource(mData.get(position).getImageId());
            ((RecyclerHolder) holder).textView.setText(mData.get(position).getName());
        } else {
            if (footState == -1) {
                holder.itemView.setVisibility(View.INVISIBLE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);
                switch (footState) {
                    case loading:
                        ((LoadMoreViewHolder) holder).textView.setText("正在加载。。。");
                        break;
                    case loadMore:
                        ((LoadMoreViewHolder) holder).textView.setText("加载更多");
                        break;
                    case loadNone:
                        ((LoadMoreViewHolder) holder).textView.setText("我是有底线的");
                        break;
                    default:
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    public RecyclerViewBean getItemBean(int position) {
        return mData.get(position);
    }

    public void onItemSwap(int fromPosition, int toPosition) {
        Collections.swap(mData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void onItemRemove(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void setFootState(int state) {
        footState = state;
    }
}

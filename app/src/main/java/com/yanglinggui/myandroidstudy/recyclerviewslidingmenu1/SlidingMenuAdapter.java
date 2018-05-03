package com.yanglinggui.myandroidstudy.recyclerviewslidingmenu1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanglinggui.myandroidstudy.R;
import com.yanglinggui.myandroidstudy.recyclerview.RecyclerViewBean;

import java.util.List;

public class SlidingMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<RecyclerViewBean> mData;
    private LayoutInflater inflater;
    private SlidingMenu mOpenMenu,isOpeningMenu;

    public SlidingMenuAdapter(Context context, List<RecyclerViewBean> data) {
        this.context = context;
        mData = data;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_slidingmenu, parent, false);
        //设置分割线
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 15;
       // layoutParams.leftMargin = parent.getLeft();
       // layoutParams.rightMargin = layoutParams.leftMargin + parent.getWidth();
        view.setLayoutParams(layoutParams);

        return new SlidingMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SlidingMenuHolder) holder).imageView.setImageResource(mData.get(position).getImageId());
        ((SlidingMenuHolder) holder).item.setText(mData.get(position).getName());
        ((SlidingMenuHolder) holder).menu.setText("侧滑菜单");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void closeMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpenMenu()) {
            mOpenMenu.closeMenu();
        }
    }

    public void saveOpenMenu(SlidingMenu menu) {
        mOpenMenu = menu;
    }

    public void saveOpeningMenu(SlidingMenu menu){
        isOpeningMenu = menu;
    }

    public SlidingMenu isExistOpenMenu(){
        return isOpeningMenu;
    }

}

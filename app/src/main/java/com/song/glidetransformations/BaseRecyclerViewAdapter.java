package com.song.glidetransformations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2016/8/27 0027.
 * Email:z53520@qq.com
 */
public abstract class BaseRecyclerViewAdapter<RD, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RD> mList;
    private static final int BOTTOM = -1;
    private static final int TOP = 0;

    private OnRVItemClickListener onRVItemClickListener;

    protected BaseRecyclerViewAdapter() {
        if (mList == null) {
            mList = new ArrayList<>();
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreatePersonalViewHolder(parent, viewType);
    }

    protected abstract VH onCreatePersonalViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        onBindPersonalViewHolder(holder, position);

        if (getItemClickState()) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(v, position);
                    if (onRVItemClickListener != null) {
                        onRVItemClickListener.onClick(v, position);
                    }
                }
            });
        }
    }

    /**
     * 需要对recyclerView的touch事件进行控制的时候，子类复写该方法，返回false；
     * @return
     */
    protected boolean getItemClickState() {
        return true;
    }

    protected void onItemClick(View view, int position) {
    }

    protected abstract void onBindPersonalViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        else
            return 0;
    }

    public void addData(RD item) {
        if (mList != null && item != null) {
            mList.add(item);
            notifyItemInserted(mList.size());
        }
    }

    public void addDatas(List<RD> itemList) {
        if (mList != null && itemList != null && !itemList.isEmpty()) {
            int size = mList.size();
            mList.addAll(itemList);
            notifyItemInserted(size + 1);
        }
    }

    public void setData(List<RD> data) {
        if (data != null) {
            if (mList != null && !mList.isEmpty()) {
                mList.clear();
            }
            if (mList != null)
                mList.addAll(data);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加item数据
     *
     * @param position 添加数据的起始位置；当位置为-1时，数据添加到末尾
     * @param item     要添加的数据
     */
    public void addData(int position, RD item) {
        if (mList != null && item != null) {
            if (position <= BOTTOM) {
                mList.add(item);
                notifyItemInserted(mList.size());
            } else {
                mList.add(position, item);
                notifyItemInserted(position);
            }
        }
    }

    /**
     * 添加beanList数据
     *
     * @param position 添加数据的起始位置；当位置为-1时，数据添加到末尾
     * @param beanList 要添加的数据
     */
    public void addListData(int position, List<RD> beanList) {
        if (mList != null && beanList != null) {
            if (position <= BOTTOM) {
                mList.addAll(beanList);
                notifyItemRangeInserted(mList.size() - beanList.size(), beanList.size());
            } else {
                mList.addAll(position, beanList);
                notifyItemRangeInserted(position, beanList.size());
            }
        }
    }

    public void addDataAtTop(RD item) {
        addData(TOP, item);
    }

    public void addDataAtBottom(RD item) {
        addData(BOTTOM, item);
    }

    public void addDataAtTop(List<RD> beanList) {
        addListData(TOP, beanList);
    }

    public void addDataAtBottom(List<RD> beanList) {
        addListData(BOTTOM, beanList);
    }

    public List<RD> getData() {
        return mList;
    }

    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        this.onRVItemClickListener = onRVItemClickListener;
    }
}

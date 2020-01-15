package com.duowan.faceit.widgets.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxun on 2017/11/30.
 */

public class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public Context context;
    protected List<T> data;
    protected OnItemClickLitener<T> mOnItemClickLitener;
    private OnItemClickWithPositionListener<T> mOnItemClickWithPositionListener;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public BaseRecycleAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public BaseRecycleAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public interface OnItemClickLitener<T> {
        void onItemClick(View view, T itemData);
    }

    public interface OnItemClickWithPositionListener<T> {
        void onItemClickWithPosition(View view, T itemData, int position);
    }

    public interface OnItemClickWithMessageIdListener<T> {
        void onItemClickWithMessageId(View view, T itemData);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public void setOnItemClickWithPositionListener(OnItemClickWithPositionListener mOnItemClickWithPositionListener) {
        this.mOnItemClickWithPositionListener = mOnItemClickWithPositionListener;
    }


    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        holder.initializeData(position);
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.itemView, data.get(position));
                }
            });
        } else if (mOnItemClickWithPositionListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (data != null && position < data.size()) {
                        mOnItemClickWithPositionListener.onItemClickWithPosition(holder.itemView, data.get(position), position);
                    }
                }
            });
        }
    }


    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void insertData(int index, T data) {
        this.data.add(index, data);
        this.notifyItemRangeChanged(index, this.data.size() - index);
    }


    public List<T> getData() {
        return data;
    }

    public T getDataAt(int position) {
        try {
            return data.get(position);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clearData() {
        if (data != null) {
            data.clear();
            notifyDataSetChanged();
        }
    }
}

package com.duowan.faceit.widgets.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liuxun on 2017/11/30.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);

    }

    public abstract void initializeData(int position);
}
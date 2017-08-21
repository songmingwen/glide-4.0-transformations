package com.song.glidetransformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Song on 2017/8/21 0021.
 * E-mail: z53520@qq.com
 */

public class TransAdapter extends BaseRecyclerViewAdapter<Transformation<Bitmap>, TransViewHolder> {
    private Context mContext;

    public TransAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    protected TransViewHolder onCreatePersonalViewHolder(ViewGroup parent, int viewType) {
        return new TransViewHolder(LayoutInflater.from(mContext).inflate(R.layout.trans_image_item, parent, false));
    }

    @Override
    protected void onBindPersonalViewHolder(RecyclerView.ViewHolder holder, int position) {
        TransViewHolder viewHolder = (TransViewHolder) holder;
        Glide.with(mContext)
                .load(R.drawable.squirrel)
                .apply(RequestOptions.bitmapTransform(getData().get(position)))
                .into(viewHolder.image);
    }
}

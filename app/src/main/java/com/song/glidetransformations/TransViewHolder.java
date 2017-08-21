package com.song.glidetransformations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Song on 2017/8/21 0021.
 * E-mail: z53520@qq.com
 */

public class TransViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;

    public TransViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.id_image_trans);
    }
}

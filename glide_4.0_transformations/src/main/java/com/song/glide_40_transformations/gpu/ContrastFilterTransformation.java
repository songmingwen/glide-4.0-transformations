package com.song.glide_40_transformations.gpu;

/**
 * Copyright (C) 2017 Song
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.security.MessageDigest;

import jp.co.cyberagent.android.gpuimage.GPUImageContrastFilter;

/**
 * contrast value ranges from 0.0 to 4.0, with 1.0 as the normal level
 */
public class ContrastFilterTransformation extends GPUFilterTransformation {

  private static final int VERSION = 1;
  private static final String ID = "com.song.trans.gpu.ContrastFilterTransformation." + VERSION;
  private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

  private float mContrast;

  public ContrastFilterTransformation(Context context) {
    this(context, Glide.get(context).getBitmapPool());
  }

  public ContrastFilterTransformation(Context context, BitmapPool pool) {
    this(context, pool, 1.0f);
  }

  public ContrastFilterTransformation(Context context, float contrast) {
    this(context, Glide.get(context).getBitmapPool(), contrast);
  }

  public ContrastFilterTransformation(Context context, BitmapPool pool, float contrast) {
    super(context, pool, new GPUImageContrastFilter());
    mContrast = contrast;
    GPUImageContrastFilter filter = getFilter();
    filter.setContrast(mContrast);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ContrastFilterTransformation;
  }

  @Override
  public int hashCode() {
    return ID.hashCode();
  }

  @Override
  public void updateDiskCacheKey(MessageDigest messageDigest) {
    messageDigest.update(ID_BYTES);
  }
}

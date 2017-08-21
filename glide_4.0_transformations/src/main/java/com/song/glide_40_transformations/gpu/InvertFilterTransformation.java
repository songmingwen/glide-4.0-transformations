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

import jp.co.cyberagent.android.gpuimage.GPUImageColorInvertFilter;

/**
 * Invert all the colors in the image.
 */
public class InvertFilterTransformation extends GPUFilterTransformation {

  private static final int VERSION = 1;
  private static final String ID = "com.song.trans.gpu.InvertFilterTransformation." + VERSION;
  private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

  public InvertFilterTransformation(Context context) {
    this(context, Glide.get(context).getBitmapPool());
  }

  public InvertFilterTransformation(Context context, BitmapPool pool) {
    super(context, pool, new GPUImageColorInvertFilter());
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof InvertFilterTransformation;
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

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

import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;

/**
 * brightness value ranges from -1.0 to 1.0, with 0.0 as the normal level
 */
public class BrightnessFilterTransformation extends GPUFilterTransformation {

  private static final int VERSION = 1;
  private static final String ID = "com.song.trans.gpu.BrightnessFilterTransformation." + VERSION;
  private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

  private float mBrightness;

  public BrightnessFilterTransformation(Context context) {
    this(context, Glide.get(context).getBitmapPool());
  }

  public BrightnessFilterTransformation(Context context, BitmapPool pool) {
    this(context, pool, 0.0f);
  }

  public BrightnessFilterTransformation(Context context, float brightness) {
    this(context, Glide.get(context).getBitmapPool(), brightness);
  }

  public BrightnessFilterTransformation(Context context, BitmapPool pool, float brightness) {
    super(context, pool, new GPUImageBrightnessFilter());
    mBrightness = brightness;
    GPUImageBrightnessFilter filter = getFilter();
    filter.setBrightness(mBrightness);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BrightnessFilterTransformation;
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

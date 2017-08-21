# glide-4.0-transformations

An Android transformation library providing a variety of image transformations for Glide4.0.

![App icon](https://github.com/songmingwen/glide-4.0-transformations/blob/master/glide.png?raw=true)

## How to use

        Glide.with(mContext)
                .load(R.drawable.squirrel)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(mContext, 15)))
                .into(viewHolder.image);
#

### Using glide-4.0-transformations in your application

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  	dependencies {
		compile 'com.github.songmingwen:glide-4.0-transformations:1.1'
		 // If you want to use the GPU Filters
    	compile 'jp.co.cyberagent.android.gpuimage:gpuimage-library:1.4.1'
	}
  
# 
    Copyright 2017 Song

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

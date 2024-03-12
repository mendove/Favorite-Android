package com.example.favorite_android.utils.imageloader

import android.graphics.drawable.Drawable

/**
 * Description:  Glide 加载回调
 * Date: 2024/2/28
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
interface ImageLoaderListener {

  fun onLoadComplete(drawable: Drawable?)

  fun onLoadFailed(throwable: Throwable?)

}
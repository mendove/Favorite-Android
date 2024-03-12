package com.example.favorite_android.utils.imageloader

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

/**
 * Description: Glide 实现类
 * Date: 2024/2/27
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class GlideImpl {


  @SuppressLint("CheckResult")
  private fun loadImage(glideRequest: RequestBuilder<Drawable>, imageView: ImageView,
                        placeHolder: Int, round: Boolean, disallowHardwareConfig: Boolean,
                        skipMemoryCache: Boolean = false, listener: ImageLoaderListener?) {

    // 如果 round 为 true 通过 .circleCropTransform() 将图片显示为圆形
    val option = if (round) RequestOptions.circleCropTransform() else RequestOptions()

    glideRequest.error(placeHolder)  // 设置图像加载失败时显示的占位符
      .transition(DrawableTransitionOptions.withCrossFade())  // 设置图像加载时的过度效果，这里使用淡入淡出效果
      .dontAnimate()  // 禁用图像加载时的动画效果
      .apply(option)  // 应用 option
      .skipMemoryCache(skipMemoryCache)  // 是否跳过内存缓存

    if (disallowHardwareConfig) {
      glideRequest.disallowHardwareConfig()  // 是否启用硬件加速
    }

    if (listener != null) {
      glideRequest.listener(object : RequestListener<Drawable> {
        // 返回值控制事件传递流程，返回 false 表示事件已被消费，不会传递给其他监听器，返回 true 继续传递
        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
          // 图像加载失败
          listener.onLoadFailed(e)
          return true
        }

        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
          // 图像加载成功
          listener.onLoadComplete(resource)
          return false
        }
      })
    }

    // 图像加载到指定的 imageView
    glideRequest.into(imageView)
  }

}
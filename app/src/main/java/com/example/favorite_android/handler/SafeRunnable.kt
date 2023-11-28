package com.example.favorite_android.handler

import com.example.favorite_android.ext.ktTry

/**
 * Description: 安全的 runnable
 * Date: 2023/11/22
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class SafeRunnable(private val runnable: Runnable) : Runnable {
  override fun run() {
    ktTry {
      runnable.run()
    }
  }
}
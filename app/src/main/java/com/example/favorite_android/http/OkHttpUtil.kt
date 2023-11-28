package com.example.favorite_android.http

import android.util.DebugUtils
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * Description: okhttp 工具类
 * Date: 2023/8/29
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class OkHttpUtil {

  companion object {
    @Volatile
    private var mInstance: OkHttpUtil? = null

    @JvmStatic
    fun getInstance(): OkHttpUtil {
      return mInstance ?: synchronized(this) {
        mInstance ?: OkHttpUtil()
      }
    }
  }

}
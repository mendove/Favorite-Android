package com.example.favorite_android.http

import com.example.favorite_android.MyApplication
import com.example.favorite_android.utils.log.logInfo
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Description: okhttp 工具类
 * Date: 2023/8/29
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class OkHttpUtil {

  // 全局唯一 okHttpClient
  val okHttpClient : OkHttpClient by lazy {
    val okHttpClientBuilder = OkHttpClient.Builder()
      // 设置链接超时事件
      .connectTimeout(15, TimeUnit.SECONDS)
      // 设置读取超时事件
      .readTimeout(15, TimeUnit.SECONDS)
      // 设置写入超时事件
      .writeTimeout(15, TimeUnit.SECONDS)
      // 设置通用拦截器
      .addInterceptor(getCommonInterceptor())
      // 设置日志拦截器
      .addInterceptor(getLoggingInterceptor())

    okHttpClientBuilder.build()
  }

  /**
   * 获取 http 通用拦截器
   */
  private fun getCommonInterceptor() = object : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
      val request = chain.request()  // 返回当前请求原始的 request
        .newBuilder()  // request 对象不可变，需要使用 newBuilder 创建一个可变的副本，用于添加新的属性
        .addHeader("token","")  // 用于向请求头中添加一个自定义键值对，此处位 token
        .build() // 构建最终修改后的请求

      // 请求的 url
      val requestUrl = request.url.toString()

      var newChain = chain
      if (requestUrl == "") {
        // 可以通过判断请求的 url 给不同接口添加不同的超时时常，如果没有符合条件，则使用 okHttpClient 设置的超时时常
        newChain = chain.withConnectTimeout(15_000,TimeUnit.MILLISECONDS)  // TimeUnit.MILLISECONDS 表示单位为浩渺
          .withReadTimeout(15_000, TimeUnit.MILLISECONDS)
          .withWriteTimeout(15_000, TimeUnit.MILLISECONDS)
      }

      return  newChain.proceed(request)
    }

  }

  /**
   * 获取 okhttp 日志拦截器
   */
  private fun getLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor { message ->
      if (MyApplication.instance().isDebug) {
        logInfo("okHttp -------- $message")
      }
    }
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
  }

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
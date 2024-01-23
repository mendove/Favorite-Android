package com.example.favorite_android.http

import android.provider.ContactsContract.Contacts
import com.example.favorite_android.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Description: Retrofit 工具类
 * Date: 2023/8/28
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class RetrofitNet private constructor() {

  lateinit var retrofit: Retrofit

  var service: IService

  companion object {

    @Volatile
    private var INSTANCE : RetrofitNet? = null

    /**
     * 懒汉式创建单例，多线程使用双重检查锁定
     */
    // fun getInstance() : RetrofitNet {
    //  return INSTANCE ?: synchronized(this) {
    //    INSTANCE ?: RetrofitNet().also { INSTANCE = it }
    //  }
    // }

    /**
     * lazy 创建懒汉单例，线程安全
     */
    val instance : RetrofitNet by lazy {
      RetrofitNet()
    }

  }

  init {
    val okHttpClient = OkHttpUtil.getInstance().okHttpClient
    retrofit = Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl("http://" + Constants.DEFAULT_DOMAIN_NAME)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    service = retrofit.create(IService::class.java)
  }

}
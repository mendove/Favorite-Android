package com.example.favorite_android.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.favorite_android.http.RetrofitNet
import retrofit2.Retrofit
import kotlin.concurrent.thread

/**
 * Description:  handle 实例 VM
 * Date: 2024/3/26
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class HandleTestVM : ViewModel() {

  var lastGetLocationTime : Long = 0L

  /**
   * 获取高德定位
   */
  fun getGdLocation() {

  }

}
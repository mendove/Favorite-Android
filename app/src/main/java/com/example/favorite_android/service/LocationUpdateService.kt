package com.example.favorite_android.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.favorite_android.common.KEY_EVENT_GD_LOCATION
import com.example.favorite_android.http.RetrofitNet
import com.jeremyliao.liveeventbus.LiveEventBus
import kotlinx.coroutines.*

/**
 * Description: 高德定位 Service
 * Date: 2023/10/25
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class LocationUpdateService : Service() {

  private var job : Job? = null

  override fun onCreate() {
    super.onCreate()
    job = CoroutineScope(Dispatchers.Default).launch {
      while (isActive) {
        try {
          val response = RetrofitNet.instance.service.getLocationByGD().execute().body()
          LiveEventBus.get<Any>(KEY_EVENT_GD_LOCATION).post(response)
          println("高德定位请求结果 $response")
        } catch (e: Exception) {
          println("异常 ： $e")
        }
        delay(20_000)  // 20秒
      }
    }
  }

  override fun onDestroy() {
    job?.cancel()
    super.onDestroy()
  }

  override fun onBind(p0: Intent?): IBinder? {
    return null
  }

}
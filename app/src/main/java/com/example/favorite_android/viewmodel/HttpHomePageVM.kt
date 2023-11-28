package com.example.favorite_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_android.http.RetrofitNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import kotlin.concurrent.thread

/**
 * Description: Http首页VM
 * Date: 2023/10/8
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class HttpHomePageVM : ViewModel(){

  fun getWeatherByGD(city : String) {
    thread {
      try {
        val response = RetrofitNet.instance.service.getWeatherByGD().execute().body()
        println("高德天气请求结果 : $response")
      } catch (e : Exception) {
        println("异常 ：$e")
      }

    }
  }

  fun getLocationByGD() {
    viewModelScope.launch(Dispatchers.IO) {
      try {
        val  response = RetrofitNet.instance.service.getLocationByGD().execute().body()
        println("高德定位请求结果 $response")
      } catch (e : Exception) {
        println("异常 ： $e")
      }
    }
  }

}
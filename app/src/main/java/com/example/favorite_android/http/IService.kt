package com.example.favorite_android.http

import com.example.favorite_android.common.Constants
import com.example.favorite_android.http.bean.locationBean.GDLocationBean
import com.example.favorite_android.http.bean.weatherBean.GDWeatherBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IService {

  @GET("https://restapi.amap.com/v3/weather/weatherInfo?key=59bf6c6833abb2a9a2b8a7c9e6a48572&city=110101")
  fun getWeatherByGD() : Call<GDWeatherBean>
  // fun getWeatherByGD(@Query("key") key: String = Constants.KEY_GD_WEATHER, @Query("city") city: String) : Call<GDWeatherBean>

  @GET("https://restapi.amap.com/v3/ip?key=${Constants.KEY_GD_WEB}")
  fun getLocationByGD() : Call<GDLocationBean>

}
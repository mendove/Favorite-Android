package com.example.favorite_android.http.bean.weatherBean

import com.google.gson.annotations.SerializedName

/**
 * Description: 高德天气 lives bean
 * Date: 2023/10/9
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
data class GDWeatherLivesBean (
  @SerializedName("province")
  val province: String,
  @SerializedName("city")
  val city: String,
  @SerializedName("adcode")
  val adcode: String,
  @SerializedName("weather")
  val weather: String,
  @SerializedName("temperature")
  val temperature: String,
  @SerializedName("winddirection")
  val winddirection: String,
  @SerializedName("windpower")
  val windpower: String,
  @SerializedName("humidity")
  val humidity: String,
  @SerializedName("reporttime")
  val reporttime: String,
  @SerializedName("temperature_float")
  val temperatureFloat: Float,
  @SerializedName("humidity_float")
  val humidityFloat: Float
)


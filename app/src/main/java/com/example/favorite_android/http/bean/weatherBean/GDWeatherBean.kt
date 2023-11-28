package com.example.favorite_android.http.bean.weatherBean

import com.google.gson.annotations.SerializedName

/**
 * Description: 高德天气最外层bean
 * Date: 2023/10/8
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
data class GDWeatherBean(
  val status : String,
  val count : String,
  val info : String,
  @SerializedName("infocode")
  val infoCode : String,
  val lives: List<GDWeatherLivesBean>
)
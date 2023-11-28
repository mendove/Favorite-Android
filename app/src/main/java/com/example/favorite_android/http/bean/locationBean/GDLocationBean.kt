package com.example.favorite_android.http.bean.locationBean

/**
 * Description: 高德定位信息 Bean
 * Date: 2023/10/19
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
data class GDLocationBean(
  val status : String,
  val info : String,  //
  val infocode : String,  // 状态码 10000 代表正确
  val province : String,  // 省份名称
  val city : String,  // 市名称
  val adcode : String  // 城市 code 编码
) {
}
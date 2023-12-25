package com.example.favorite_android.utils.log

/**
 * Description: 安全的 runnable
 * Date: 2023/12/05
 * Author: Makka
 * Email: 2364306586@qq.com
 */
interface ILog {
  // 初始化
  fun init(debuggable: Boolean, globalTag: String)

  fun debug(msg: String?= "", tag: String? = null)

  fun info(msg: String?= "", tag: String? = null)

  fun error(msg: String?= "", tag: String? = null)

  fun warning(msg: String? = "", tag: String? = null)
}
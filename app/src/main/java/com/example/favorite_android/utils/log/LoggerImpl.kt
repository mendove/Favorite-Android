package com.example.favorite_android.utils.log

import android.util.Log

/**
 * Description: 日志输出
 * Date: 2023/11/22
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class LoggerImpl {


}

/**
 * 使用系统方法输出日志
 */
fun sysPrint(throwable: Throwable) {
  println(Log.getStackTraceString(throwable))
}
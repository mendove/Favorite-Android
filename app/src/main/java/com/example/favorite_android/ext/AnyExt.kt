package com.example.favorite_android.ext

import com.example.favorite_android.utils.log.sysPrint

/**
 * Description: 扩展
 * Date: 2023/11/22
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
/**
 * try catch 的扩展函数
 */
inline fun ktTry(block: () -> Unit) {
  ktTry(block) {
    sysPrint(it)
  }
}

/**
 * try catch 的扩展函数
 */
inline fun ktTry(block: () -> Unit, catchCallback: (e: Exception) -> Unit) {
  try {
    block.invoke()
  } catch (e: Exception) {
    catchCallback.invoke(e)
  }
}
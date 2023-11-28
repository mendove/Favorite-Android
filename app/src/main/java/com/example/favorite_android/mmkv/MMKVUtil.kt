package com.example.favorite_android.mmkv

import com.example.favorite_android.common.Constants
import com.tencent.mmkv.MMKV

/**
 * Description: MMKV 工具类
 * Date: 2023/11/2
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
object MMKVUtil {

  // hashMap 存放不同类型的 MMKV 对象
  private val mmkvMap : HashMap<String,MMKV> = hashMapOf()

  init {
    mmkvMap[Constants.DEFAULT_SP_NAME] = MMKV.mmkvWithID(Constants.DEFAULT_SP_NAME, MMKV.MULTI_PROCESS_MODE)!!
  }

  fun encode(key: String, value: Any?, withId: String = Constants.DEFAULT_SP_NAME) {
    val mmkv = mmkvMap[withId] ?: return
    when (value) {
      is String -> mmkv.encode(key, value)
      is Float -> mmkv.encode(key, value)
      is Boolean -> mmkv.encode(key, value)
      is Int -> mmkv.encode(key, value)
      is Long -> mmkv.encode(key, value)
      is Double -> mmkv.encode(key, value)
      is ByteArray -> mmkv.encode(key, value)
      else -> return
    }
  }

  fun decodeInt(key: String, defaultValue: Int, withId: String = Constants.DEFAULT_SP_NAME): Int {
    return mmkvMap[withId]?.decodeInt(key, defaultValue) ?: defaultValue
  }


  fun decodeLong(key: String, defaultValue: Long, withId: String = Constants.DEFAULT_SP_NAME): Long {
    return mmkvMap[withId]?.decodeLong(key, defaultValue) ?: defaultValue
  }


  fun decodeBoolean(key: String, defaultValue: Boolean, withId: String = Constants.DEFAULT_SP_NAME): Boolean {
    return mmkvMap[withId]?.decodeBool(key, defaultValue) ?: defaultValue
  }

  fun decodeFloat(key: String, defaultValue: Float, withId: String = Constants.DEFAULT_SP_NAME): Float {
    return mmkvMap[withId]?.decodeFloat(key, defaultValue) ?: defaultValue
  }

  fun decodeString(key: String, defaultValue: String, withId: String = Constants.DEFAULT_SP_NAME): String {
    return mmkvMap[withId]?.decodeString(key, defaultValue) ?: defaultValue
  }

}
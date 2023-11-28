package com.example.favorite_android.mmkv

import com.example.favorite_android.common.Constants

/**
 * Description: SP Utils
 * Date: 2023/11/8
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class SPUtils {

  companion object{

    @JvmStatic
    fun getInt(key: String, defValue: Int, spName: String = Constants.DEFAULT_SP_NAME): Int {
      return MMKVUtil.decodeInt(key, defValue, spName)
    }

    @JvmStatic
    fun putInt(key: String, value: Int, spName: String = Constants.DEFAULT_SP_NAME) {
      MMKVUtil.encode(key, value, spName)
    }

    @JvmStatic
    fun getString(key: String, defValue: String, spName: String = Constants.DEFAULT_SP_NAME): String {
      return MMKVUtil.decodeString(key, defValue, spName)
    }

    @JvmStatic
    fun putString(key: String, value: String, spName: String = Constants.DEFAULT_SP_NAME) {
      MMKVUtil.encode(key, value, spName)
    }

    @JvmStatic
    fun getFloat(key: String, defValue: Float, spName: String = Constants.DEFAULT_SP_NAME): Float {
      return MMKVUtil.decodeFloat(key, defValue, spName)
    }

    @JvmStatic
    fun putFloat(key: String, value: Float, spName: String = Constants.DEFAULT_SP_NAME) {
      MMKVUtil.encode(key, value, spName)
    }

    @JvmStatic
    fun getBoolean(key: String, defValue: Boolean, spName: String = Constants.DEFAULT_SP_NAME): Boolean {
      return MMKVUtil.decodeBoolean(key, defValue, spName)
    }

    @JvmStatic
    fun putBoolean(key: String, value: Boolean, spName: String = Constants.DEFAULT_SP_NAME) {
      MMKVUtil.encode(key, value, spName)
    }

    @JvmStatic
    fun getLong(key: String, defValue: Long, spName: String = Constants.DEFAULT_SP_NAME): Long {
      return MMKVUtil.decodeLong(key, defValue, spName)
    }

    @JvmStatic
    fun putLong(key: String, value: Long, spName: String = Constants.DEFAULT_SP_NAME) {
      MMKVUtil.encode(key, value, spName)
    }

  }

}
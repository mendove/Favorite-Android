package com.example.favorite_android.sp

import com.example.favorite_android.mmkv.SPUtils

/**
 * Description:
 * Date: 2023/11/1
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class SPOtherUtils {

  companion object{

    private const val PASSWORD_ADMIN = "123456"

    private const val KEY_PASSWORD = "password"

    var password
      get() = SPUtils.getString(KEY_PASSWORD, PASSWORD_ADMIN)
      set(value) = SPUtils.putString(KEY_PASSWORD,value)

  }

}
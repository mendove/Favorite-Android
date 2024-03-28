package com.example.favorite_android.helper

import com.example.favorite_android.fragment.HandleTestFragment
import com.example.favorite_android.fragment.base.BaseFragment
import com.example.favorite_android.handler.TestHandle
import com.example.favorite_android.http.RetrofitNet
import kotlin.concurrent.thread

/**
 * Description: 绑定 handle 实例页面的 helper
 * Date: 2024/3/28
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class HandleTestHelper(private val mFragment: HandleTestFragment) {

  // 最后一次请求位置信息时间
  var lastGetLocationTime: Long = 0L

  /**
   * 获取高德定位
   */
  fun getGdLocation() {

    thread {

      // 小于 60S 再次请求
//      while (System.currentTimeMillis() - lastGetLocationTime < 60_000) {
//
//        lastGetLocationTime = System.currentTimeMillis()
//
//        val info = RetrofitNet.instance.service.getLocationByGD()
//
//        val msg = mFragment.mTestHandle.obtainMessage(TestHandle.MSG_WHAT_GD_LOCATION, info)
//
//        mFragment.mTestHandle.sendMsg(msg = msg)
//      }

      lastGetLocationTime = System.currentTimeMillis()

      val info = RetrofitNet.instance.service.getLocationByGD().execute().body()

      val msg = info?.let {
        mFragment.mTestHandle.obtainMessage(TestHandle.MSG_WHAT_GD_LOCATION,
          it
        )
      }

      mFragment.mTestHandle.sendMsg(msg = msg)

    }

  }


}
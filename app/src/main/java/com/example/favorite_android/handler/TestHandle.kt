package com.example.favorite_android.handler

import android.os.Handler
import android.os.Message
import com.example.favorite_android.fragment.HandleTestFragment
import com.example.favorite_android.fragment.base.BaseFragment
import com.example.favorite_android.http.bean.locationBean.GDLocationBean
import com.example.favorite_android.utils.log.logInfo

/**
 * Description:
 * Date: 2024/3/26
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class TestHandle(var mFragment : HandleTestFragment) : MainHandler.IHandleMessage{

  init {
    MainHandler.instance().also {
      it.addHandleMessageCallback(this)
    }
  }

  /**
   * [Handler.obtainMessage]
   */
  fun obtainMessage(what: Int, any: Any): Message = MainHandler.instance().obtainMessage(what, any)

  /**
   * 发送消息
   */
  fun sendMsg(handler: Handler = MainHandler.instance(),msg : Message? = null) {

    logInfo("handle test 发送消息")

    if (msg == null) {
      return
    }

    handler.sendMessage(msg)
  }

  override fun handleMessage(msg: Message): Boolean {

    logInfo("handle test 收到消息 ${msg.what}")

    when(msg.what) {
      MSG_WHAT_GD_LOCATION -> {
        // 收到高德位置信息消息
        mFragment.getLocationInfoByHandle(msg.obj as GDLocationBean)
      }
      else -> {
        return true
      }
    }

    return false
  }


  companion object {

    // 高德位置信息
    const val MSG_WHAT_GD_LOCATION = 2000

  }
}
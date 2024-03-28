package com.example.favorite_android.handler

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.jeremyliao.liveeventbus.utils.ThreadUtils.isMainThread

/**
 * Description: 全局主线程 handler
 * Date: 2023/11/20
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class MainHandler : Handler(Looper.getMainLooper()) {

  private var mHandleMessage = arrayListOf<IHandleMessage>()

  override fun handleMessage(msg: Message) {
    mHandleMessage.forEach {
      if (!it.handleMessage(msg)) {
        return
      }
    }
  }

  /**
   * [Handler.removeCallbacks]
   */
  fun removeCallback(runnable: Runnable?) {
    if (runnable == null) {
      return
    }
    removeCallbacks(runnable)
  }


  /**
   * [Handler.postDelayed]
   */
  fun postDelayed(delayMillis: Long, runnable: Runnable?) {
    if (runnable != null) {
      postDelayed(runnable, delayMillis)
    }
  }

  /**
   * 发送消息
   * @param what 消息的 what
   * @param delayMillis 消息的延迟发送时间，不需要延时传 0
   * @param isRemoveWhatFirst 是否先移除之前的这个消息
   * @param msg [Message] 可以为 null
   */
  fun sendMsg(what: Int, delayMillis: Long = 0, isRemoveWhatFirst: Boolean = true, msg: Message? = null) {
    if (isRemoveWhatFirst) {
      removeMessages(what)
    }

    if (msg == null) {
      if (delayMillis <= 0) {
        sendEmptyMessage(what)
      } else {
        sendEmptyMessageDelayed(what, delayMillis)
      }
      return
    }

    if (delayMillis <= 0) {
      sendMessage(msg)
    } else {
      sendMessageDelayed(msg, delayMillis)
    }
  }

  /**
   * 添加 HandleMessage 回调
   */
  fun addHandleMessageCallback(handlerMessage: IHandleMessage) {
    mHandleMessage.add(handlerMessage)
  }

  companion object {

    @Volatile
    var INSTANCE : MainHandler? = null

    /**
     * 获取单例
     */
    @JvmStatic
    fun instance(): MainHandler {
      return INSTANCE ?: synchronized(this) {
        INSTANCE ?: MainHandler().also {
          INSTANCE = it
        }
      }
    }
  }

  /**
   * handlerMessage 方法的回调
   */
  interface IHandleMessage {
    /**
     * 处理 message 消息
     * @param msg [Message]
     * @return 是否继续向下传递，false 不继续了，true 继续调用其它监听者处理
     */
    fun handleMessage(msg: Message): Boolean
  }

}

/**
 * 主线程检查，如果在主线程则直接调用 run 方法，不在的话调用 [mainPost]
 */
fun Any.mainSafeCheck(runnable: SafeRunnable) {
  if (isMainThread()) {
    runnable.run()
    return
  }

  mainSafePost(runnable)
}

/**
 * 调用 [Handler.post]
 */
fun Any.mainSafePost(runnable: SafeRunnable) {
  MainHandler.instance().post(runnable)
}

/**
 * 调用 [Handler.postDelayed]
 */
fun Any.mainSafeDelayed(delayMillis: Long, runnable: SafeRunnable) {
  MainHandler.instance().postDelayed(delayMillis, runnable)
}

/**
 * 调用 [Handler.removeCallbacks]
 */
fun Any.mainRemoveCallback(runnable: Runnable?) {
  MainHandler.instance().removeCallback(runnable)
}

/**
 * 发送消息
 * @param what 消息的 what
 * @param delayMillis 消息的延迟发送时间，不需要延时传 0
 * @param isRemoveWhatFirst 是否先移除之前的这个消息
 * @param msg [Message] 可以为 null
 */
fun Any.mainSendMsg(what: Int, delayMillis: Long = 0, isRemoveWhatFirst: Boolean = true, msg: Message? = null) {
  MainHandler.instance().sendMsg(what, delayMillis, isRemoveWhatFirst, msg)
}

/**
 * 移除消息
 */
fun Any.mainRemoveMsg(what: Int) {
  MainHandler.instance().removeMessages(what)
}
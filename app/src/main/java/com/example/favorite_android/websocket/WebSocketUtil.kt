package com.example.favorite_android.websocket

import com.example.favorite_android.http.OkHttpUtil
import com.example.favorite_android.utils.log.logInfo
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

/**
 * Description: 基于 okhhtp 实现 websocket 客户端
 * Date: 2024/1/16
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class WebSocketUtil(
  // 需要链接的 url
  private var url : String
){

  // WebSocket 地址的 request
  private var mRequest: Request? = null

  //当前WebSocket连接状态
  private var mCurrentStatus = DISCONNECTED

  private val innerListener = object : WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
      // WebSocket 成功建立链接时调用
      // webSocket 建立链接的 websocket 对象
      // response 是 OkHttp 中的 Response 对象，包含与 WebSocket 连接相关的信息，例如握手的响应头等
      setCurrentStatus(CONNECTED)  // 设置 websocket 链接状态为已链接
      logInfo("WebSocket 链接成功 ")
      super.onOpen(webSocket, response)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
      // webSocket 是发生错误的 WebSocket 连接对象。
      // t 是引发错误的异常。
      // response 是 OkHttp 中的 Response 对象，包含与错误相关的信息，可能为 null。
      super.onFailure(webSocket, t, response)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
      // 接收到二进制消息时候调用
      // bytes 接收到的二进制消息
      super.onMessage(webSocket, bytes)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
      // 接收到文本消息时调用
      // 接收到的文本消息
      super.onMessage(webSocket, text)
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
      // websocket 正在关闭时调用
      // webSocket 是正在关闭的 WebSocket 连接对象。
      // code 是关闭的状态码。
      // reason 是关闭的原因。
      super.onClosing(webSocket, code, reason)
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
      // webSocket 是已关闭的 WebSocket 连接对象。
      // code 是关闭的状态码。
      // reason 是关闭的原因。
      super.onClosed(webSocket, code, reason)
    }

  }

  /**
   * 链接处理
   */
  fun connect() {
    when (mCurrentStatus) {
      DISCONNECTED -> {

        setCurrentStatus(CONNECTING)

        if (mRequest == null) {
          mRequest = Request.Builder()
            .url(url)
            .build()
        }

        //使用OKHttp创建WebSocket连接
        OkHttpUtil.getInstance().okHttpClient.newWebSocket(mRequest!!, innerListener)
        //由于创建WebSocket是在子线程，所以创建完要关闭掉
        OkHttpUtil.getInstance().okHttpClient.dispatcher.executorService.shutdown()
      }
    }
  }

  /**
   * 设置 websocket 链接状态
   */
  fun setCurrentStatus(status: Int) {
    mCurrentStatus = status
  }

}
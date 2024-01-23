package com.example.favorite_android.websocket

/**
 * Description: WebSocket 配置
 * Date: 2024/1/17
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
//WebSocket状态
internal const val DISCONNECTED = -1 //已断开
internal const val CONNECTING = 0 //连接中
internal const val CONNECTED = 1 //已连接
internal const val RECONNECT = 2 //重连
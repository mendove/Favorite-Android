package com.example.favorite_android

import android.app.Application
import android.content.Intent
import com.example.favorite_android.service.LocationUpdateService
import com.example.favorite_android.utils.log.LoggerImpl
import com.jeremyliao.liveeventbus.LiveEventBus
import com.tencent.mmkv.MMKV

/**
 * Description: 全局 Application
 * Date: 2023/10/25
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    mInstance = this

    // 启动高德定位服务
    startGDLocationService()

    // 初始化 Live Event Bus
    initLiveEventBus()

    // 初始化 mmkv
    initMMKV()

    // 初始化日志
    initLogger()
  }

  /**
   * 初始化日志
   */
  private fun initLogger() {
    LoggerImpl.getInstance().init(true,"Favorite")
  }

  /**
   * 启动高德定位服务
   */
  private fun startGDLocationService() {
    val serviceIntent = Intent(this,LocationUpdateService::class.java)
    startService(serviceIntent)
  }

  /**
   * 初始化 Live Event Bus
   */
  private fun initLiveEventBus() {
    LiveEventBus.config()
      .lifecycleObserverAlwaysActive(true) // 如果你想始终保持生命周期感知
      .setContext(this.applicationContext)
  }

  /**
   * 初始化 MMKV
   */
  private fun initMMKV() {
    MMKV.initialize(this)
  }

  // 是否是 Debug 模式
  val isDebug = BuildConfig.DEBUG

  companion object {
    private lateinit var mInstance: MyApplication

    @JvmStatic
    fun instance(): MyApplication = mInstance
  }

}

/**
 * 获取全局的 application
 */
fun getDefaultApp() = MyApplication.instance()
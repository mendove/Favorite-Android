package com.example.favorite_android.utils.log

import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * Description: 日志输出
 * Date: 2023/11/22
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class LoggerImpl : ILog{

  companion object {
    @Volatile
    private var mInstance: LoggerImpl? = null

    @JvmStatic
    fun getInstance(): LoggerImpl {
      return mInstance ?: synchronized(this) {
        mInstance ?: LoggerImpl()
      }
    }
  }

  override fun init(debuggable: Boolean, globalTag: String) {
    //  PrettyFormatStrategy 是 Logger 库中用于格式化输出日志的策略类。newBuilder() 是创建一个新的策略构建器。
    Logger.addLogAdapter(AndroidLogAdapter(PrettyFormatStrategy.newBuilder()
      // 是否显示线程信息
      .showThreadInfo(false)
      // 这个方法设置显示调用栈的方法数量。这里设置为 3 表示输出日志时将显示调用栈的前 3 个方法。
      .methodCount(3)
      // 这个方法设置方法偏移量。这是为了确定起始位置的偏移量，以便正确显示调用栈的信息。
      // 偏移量为 2，意味着从调用日志的地方向上偏移 2 个方法，从而显示相关的调用栈信息。
      .methodOffset(2)
      // 这个方法设置日志的全局标签（Tag）。globalTag 变量应该是一个字符串，表示要添加到日志中的全局标签。
      .tag(globalTag)
      .build()))
  }

  override fun debug(msg: String?, tag: String?) {
    //华为手机默认屏蔽了debug级别的输出，info以上是可以打印的，所以建议调用时还是建议用info级别
    if (msg != null) {
      Logger.t(tag).d(msg)
    }
  }

  override fun info(msg: String?, tag: String?) {
    if (msg != null) {
      Logger.t(tag).i(msg)
    }
  }

  override fun error(msg: String?, tag: String?) {
    if (msg != null) {
      Logger.t(tag).e(msg)
    }
  }

  /**
   * 警告级别日志输出
   */
  override fun warning(msg: String?, tag: String?) {
    if (msg != null) {
      Logger.t(tag).w(msg)
    }
  }

}

// ----------------------------- 扩展 --------------------------
fun logDebug(msg: String?, tag: String? = null) {
  //华为手机默认屏蔽了debug级别的输出，info以上是可以打印的，所以建议调用时还是建议用info级别
  LoggerImpl.getInstance().debug(msg, tag)
}

fun logInfo(msg: String?, tag: String? = null) {
  LoggerImpl.getInstance().info(msg, tag)
}

fun logError(msg: String?, tag: String? = null) {
  LoggerImpl.getInstance().error(msg, tag)
}

fun logWarning(msg: String?, tag: String? = null) {
  LoggerImpl.getInstance().warning(msg, tag)
}

/**
 * 使用系统方法输出日志
 */
fun sysPrint(throwable: Throwable) {
  println(Log.getStackTraceString(throwable))
}
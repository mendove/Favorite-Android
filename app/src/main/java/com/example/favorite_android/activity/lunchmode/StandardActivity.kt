package com.example.favorite_android.activity.lunchmode

import android.content.Intent
import android.os.Bundle
import com.example.favorite_android.activity.base.BaseActivity
import com.example.favorite_android.databinding.ActivityStandardBinding
import com.example.favorite_android.utils.log.logInfo

/**
 * Description: 默认启动模式 Activity
 * Date: 2023/12/20
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class StandardActivity : BaseActivity<ActivityStandardBinding>(ActivityStandardBinding::inflate) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    logInfo("StandardActivity onCreate")
    initView()
  }

  private fun initView() {
    mViewBinding.tvStandard.setOnClickListener {
      val intent = Intent(this, LunchTestActivity::class.java)
      startActivity(intent)
    }
  }

  override fun onStart() {
    super.onStart()
    logInfo("StandardActivity onStart")
  }

  override fun onResume() {
    super.onResume()
    logInfo("StandardActivity onResume")
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    logInfo("StandardActivity onNewIntent")
  }

  override fun onPause() {
    super.onPause()
    logInfo("StandardActivity onPause")
  }

  override fun onStop() {
    super.onStop()
    logInfo("StandardActivity onStop")
  }

  override fun onDestroy() {
    super.onDestroy()
    logInfo("StandardActivity onDestroy")
  }

}
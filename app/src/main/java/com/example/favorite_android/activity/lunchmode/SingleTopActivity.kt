package com.example.favorite_android.activity.lunchmode

import android.content.Intent
import android.os.Bundle
import com.example.favorite_android.activity.base.BaseActivity
import com.example.favorite_android.databinding.ActivitySingleTopBinding
import com.example.favorite_android.utils.log.logInfo

/**
 * Description: 栈顶复用 Activity
 * Date: 2023/12/20
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class SingleTopActivity :
  BaseActivity<ActivitySingleTopBinding>(ActivitySingleTopBinding::inflate) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
    logInfo("SingleTopActivity onCreate")
  }

  private fun initView() {
    mViewBinding.tvSingleTop.setOnClickListener {
      val intent = Intent(this,LunchTestActivity::class.java)
      startActivity(intent)
    }
  }

  override fun onStart() {
    super.onStart()
    logInfo("SingleTopActivity onStart")
  }

  override fun onResume() {
    super.onResume()
    logInfo("SingleTopActivity onResume")
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    logInfo("SingleTopActivity onNewIntent")
  }

  override fun onPause() {
    super.onPause()
    logInfo("SingleTopActivity onPause")
  }

  override fun onStop() {
    super.onStop()
    logInfo("SingleTopActivity onStop")
  }

  override fun onDestroy() {
    super.onDestroy()
    logInfo("SingleTopActivity onDestroy")
  }

}
package com.example.favorite_android.activity.lunchmode

import android.content.Intent
import android.os.Bundle
import com.example.favorite_android.activity.base.BaseActivity
import com.example.favorite_android.databinding.ActivityLunchModeBinding
import com.example.favorite_android.utils.log.logInfo

/**
 * Description: 启动模式 Activity
 * Date: 2023/12/18
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class LunchModeActivity : BaseActivity<ActivityLunchModeBinding>(ActivityLunchModeBinding::inflate){

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
  }

  override fun onStart() {
    super.onStart()
  }

  override fun onResume() {
    super.onResume()
  }

  override fun onPause() {
    super.onPause()
    logInfo("LunchModeActivity onPause")
  }

  override fun onStop() {
    super.onStop()
    logInfo("LunchModeActivity onStop")
  }

  override fun onDestroy() {
    super.onDestroy()
    logInfo("LunchModeActivity onDestroy")
  }


  private fun initView() {
    mViewBinding.run {
      btStandard.setOnClickListener {
        val intent = Intent(this@LunchModeActivity,StandardActivity::class.java)
        startActivity(intent)
      }
      btSingleTop.setOnClickListener {
        val intent = Intent(this@LunchModeActivity,SingleTopActivity::class.java)
        startActivity(intent)
      }
      btSingleTask.setOnClickListener {

      }
      btSingleInstance.setOnClickListener {

      }
    }
  }

}
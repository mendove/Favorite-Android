package com.example.favorite_android.activity

import android.content.Intent
import android.os.Bundle
import com.example.favorite_android.MainActivity
import com.example.favorite_android.activity.base.BaseActivity
import com.example.favorite_android.activity.lunchmode.LunchModeActivity
import com.example.favorite_android.databinding.ActivityHomePageBinding

/**
 * Description: 首页 Activity
 * Date: 2023/12/11
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class HomePageActivity : BaseActivity<ActivityHomePageBinding>(ActivityHomePageBinding::inflate) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
  }

  private fun initView() {
    mViewBinding.run {
      btActivityLunch.setOnClickListener {
        val intent = Intent(this@HomePageActivity,LunchModeActivity::class.java)
        startActivity(intent)
      }
      btFunction.setOnClickListener {
        val intent = Intent(this@HomePageActivity,MainActivity::class.java)
        startActivity(intent)
      }
    }
  }

}
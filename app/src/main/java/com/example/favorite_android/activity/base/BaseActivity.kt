package com.example.favorite_android.activity.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Description: 封装了 ViewBinding 创建销毁的 Activity
 * Date: 2023/11/30
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
open class BaseActivity<VB : ViewBinding>(
  private val vbInflate: (inflater: LayoutInflater) -> VB
)  : AppCompatActivity() {

  private var mBinding: VB? = null

  protected val mViewBinding get() = mBinding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinding = vbInflate(layoutInflater)
    setContentView(mBinding!!.root)
  }

  override fun onDestroy() {
    super.onDestroy()
    mBinding = null
  }

}
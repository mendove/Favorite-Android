package com.example.favorite_android.fragment.test

import android.os.Bundle
import android.view.View
import com.example.favorite_android.R
import com.example.favorite_android.databinding.FragmentTestKeyboardBinding
import com.example.favorite_android.fragment.base.BaseVBFragment

/**
 * Description: 测试键盘顶起布局
 * Date: 2023/8/21
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class TestKeyboardFragment : BaseVBFragment<FragmentTestKeyboardBinding>(FragmentTestKeyboardBinding::inflate){

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  private fun initView() {
    initToolbar(binding.toolbar,getString(R.string.test_keyboard))
  }

}
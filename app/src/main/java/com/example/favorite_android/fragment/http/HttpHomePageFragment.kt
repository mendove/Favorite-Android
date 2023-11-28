package com.example.favorite_android.fragment.http

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.favorite_android.R
import com.example.favorite_android.databinding.FragmentHttpHomeBinding
import com.example.favorite_android.fragment.base.BaseVBFragment
import com.example.favorite_android.viewmodel.HttpHomePageVM

/**
 * Description: HTTP 通讯首页
 * Date: 2023/8/3
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class HttpHomePageFragment : BaseVBFragment<FragmentHttpHomeBinding>(FragmentHttpHomeBinding::inflate) {

  private val mViewModel : HttpHomePageVM by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  private fun initView() {
    initToolbar(binding.toolbar,getString(R.string.http_test))

    binding.btGetWeather.setOnClickListener {
      mViewModel.getWeatherByGD("")
    }

    binding.btGetLocation.setOnClickListener {
      mViewModel.getLocationByGD()
    }
  }

}
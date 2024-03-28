package com.example.favorite_android.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.favorite_android.databinding.FragmentHandleTestBinding
import com.example.favorite_android.fragment.base.BaseVBFragment
import com.example.favorite_android.fragment.viewmodel.HandleTestVM
import com.example.favorite_android.handler.TestHandle
import com.example.favorite_android.helper.HandleTestHelper
import com.example.favorite_android.http.bean.locationBean.GDLocationBean
import com.example.favorite_android.viewmodel.HttpHomePageVM

/**
 * Description: Handle Test Fragment
 * Date: 2024/3/13
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class HandleTestFragment : BaseVBFragment<FragmentHandleTestBinding>(FragmentHandleTestBinding::inflate) {

  private val mViewModel : HandleTestVM by viewModels()

  val mTestHandle by lazy {TestHandle(this)}

  val mTestHandleHelper by lazy { HandleTestHelper(this) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  fun initView() {

    mBinding?.btLocation?.setOnClickListener {
      mTestHandleHelper.getGdLocation()
    }

  }

  fun getLocationInfoByHandle(info : GDLocationBean) {
    mBinding?.tvLocation?.text = "${info.province} 省  ${info.city} 市"
  }

}
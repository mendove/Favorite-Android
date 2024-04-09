package com.example.favorite_android.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.favorite_android.databinding.FragmentRoomTestBinding
import com.example.favorite_android.db.AppDatabase
import com.example.favorite_android.db.bean.RoomTestBean
import com.example.favorite_android.fragment.base.BaseVBFragment
import com.example.favorite_android.fragment.vm.RoomTestVM
import com.example.favorite_android.viewmodel.HttpHomePageVM

/**
 * Description:  Room 数据库实例 Fragment
 * Date: 2024/3/29
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class RoomTestFragment : BaseVBFragment<FragmentRoomTestBinding>(FragmentRoomTestBinding::inflate) {

  private val mViewModel : RoomTestVM by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  fun initView() {
    initToolbar(mBinding?.toolbar!!,"Room test")

    mBinding?.btAdd?.setOnClickListener {

      val userName = mBinding?.etUserName?.text.toString()

      val password = mBinding?.etPassword?.text.toString()

      mViewModel.addRoomTestInfo(RoomTestBean(userName = userName, password = password))

    }

    mBinding?.btSelect?.setOnClickListener {

      mViewModel.selectAll()

    }
  }

}
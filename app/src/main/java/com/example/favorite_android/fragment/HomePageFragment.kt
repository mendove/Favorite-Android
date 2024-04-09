package com.example.favorite_android.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.favorite_android.R
import com.example.favorite_android.databinding.FragmentHomePageBinding
import com.example.favorite_android.fragment.base.BaseVBFragment

class HomePageFragment : BaseVBFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  private fun initView() {
    initToolbar(binding.toolbar,getString(R.string.home_page))

    binding.btHttp.setOnClickListener {
      findNavController().navigate(R.id.action_homePageFragment_to_httpHomePageFragment)
    }

    binding.btTestKeyboard.setOnClickListener {
      findNavController().navigate(R.id.action_homePageFragment_to_testKeyboardFragment)
    }

    binding.btHandleTest.setOnClickListener {
      findNavController().navigate(R.id.action_homePageFragment_to_handleTestFragment)
    }

    binding.btRoomTest.setOnClickListener {
      findNavController().navigate(R.id.action_homePageFragment_to_roomTestFragment)
    }

    binding.btCoroutineTest.setOnClickListener {
      findNavController().navigate(R.id.action_homePageFragment_to_coroutineTestFragment)
    }

  }

}
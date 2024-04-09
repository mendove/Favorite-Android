package com.example.favorite_android.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import com.example.favorite_android.getDefaultApp

/**
 * Description:
 * Date: 2024/4/9
 * Author: Makka
 * Email: 2364306586@qq.com
 */
open class BaseVBVMFragment<VB : ViewBinding,VM : ViewModel>(private val vbInflate: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> VB) : BaseFragment() {

  protected var mBinding: VB? = null

  protected lateinit var mViewModel: VM

  protected val binding get() = mBinding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    mBinding = vbInflate(inflater, container, false)
    return mBinding!!.root
  }

  protected fun initBase(modelClass: Class<VM>, owner: ViewModelStoreOwner = this) {
    // 检查 viewModel 是否已经被初始化
    if (!this::mViewModel.isInitialized) {
      // ViewModelProvider 用于创建和管理 ViewModel 实力
      mViewModel = ViewModelProvider(owner, ViewModelProvider.AndroidViewModelFactory.getInstance(getDefaultApp())).get(modelClass)
    }
  }

  @CallSuper
  override fun onDestroyView() {
    super.onDestroyView()
    mBinding = null
  }

}
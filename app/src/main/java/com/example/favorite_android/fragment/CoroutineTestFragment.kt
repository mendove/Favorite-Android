package com.example.favorite_android.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.favorite_android.R
import com.example.favorite_android.databinding.FragmentCoroutineTestBinding
import com.example.favorite_android.fragment.base.BaseVBFragment
import com.example.favorite_android.fragment.base.BaseVBVMFragment
import com.example.favorite_android.fragment.vm.CoroutineTestVM
import com.example.favorite_android.utils.log.logInfo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Description:  协程示例 Fragment
 * Date: 2024/4/9
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class CoroutineTestFragment : BaseVBVMFragment<FragmentCoroutineTestBinding, CoroutineTestVM>(FragmentCoroutineTestBinding::inflate) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initBase(CoroutineTestVM::class.java)
    initView()
    addObserver()
  }

  fun initView() {
    initToolbar(mBinding!!.toolbar, getString(R.string.add))

    mBinding?.btSelectUser?.setOnClickListener {
      selectUserInfo()
    }

    mBinding?.btSelectLocation?.setOnClickListener {
      selectLocationInfo()
    }
  }

  fun addObserver() {

    mViewModel.userDataLiveData.observe(viewLifecycleOwner) {
      mBinding?.tvUserList?.text = it.toString()
    }

    mViewModel.locationInfoLiveData.observe(viewLifecycleOwner) {
      mBinding?.tvUserList?.text = it.toString()
    }

  }

  /**
   * 创建协程的方法1
   */
  fun crateCoroutine1() {
    // 使用 runBlocking 顶层函数创建 不建议使用
    // 开启一个协程并阻塞当前线程直到其内部所有逻辑执行完毕
    // 开启 runBlocking{} 这种协程之后就是在MAIN线程执行了
    runBlocking {

    }
  }

  /**
   * 创建协程的方法2
   */
  @OptIn(DelicateCoroutinesApi::class)
  fun crateCoroutine2() {
    // 使用 GlobalScope 单例对象直接调用 launch/async 开启协程 不建议使用
    // 适合在应用范围内开启一个新的协程，协程生命周期与应用一致
    // 可以指定运行线程，不指定默认子线程
    GlobalScope.launch {

    }
  }

  var mCoroutineScope: CoroutineScope? = null

  /**
   * 创建协程的方法3
   */
  fun crateCoroutine3() {
    // 创建一个 CoroutineScope 对象
    // 创建时指定运行线程 默认运行在子线程
    mCoroutineScope = CoroutineScope(Dispatchers.Main)
    mCoroutineScope?.launch {
      logInfo("coroutineScope launch thread name ---- ${Thread.currentThread().name}")
    }
  }


  var mMainScope: CoroutineScope? = null

  /**
   * 创建线程方法4
   */
  fun crateCoroutine4() {
    // 创建一个MainScope 对象，默认运行在UI线程
    mMainScope = MainScope()
    mMainScope?.launch {
      logInfo("mainScope launch thread name ---- ${Thread.currentThread().name}")
    }
  }

  /**
   * 创建线程方法5
   */
  fun crateCoroutine5() {
    //方法六：在Activity/Fragment 启动一个协程，该协程默认运行在UI线程（推荐使用），
    //协程和该组件生命周期绑定，Activity/Fragment销毁时，协程一并销毁，从而实现安全可靠地协程调用。
    //调用lifecycleScope.launch{} 或 lifecycleScope.async{} 方法的时候可以指定运行线程（根据指定的线程来，不指定默认是UI线程）。
    lifecycleScope.launch {

    }
  }

  /**
   * 使用 MVVM 架构，在 ViewModel 中使用协程
   */
  fun selectUserInfo() {
    mViewModel.realSelect()
  }

  fun selectLocationInfo() {
    mViewModel.selectLocation()
  }

}
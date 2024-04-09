package com.example.favorite_android.fragment.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_android.db.AppDatabase
import com.example.favorite_android.db.bean.RoomTestBean
import com.example.favorite_android.http.RetrofitNet
import com.example.favorite_android.http.bean.locationBean.GDLocationBean
import com.example.favorite_android.utils.log.logInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Description:
 * Date: 2024/4/9
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class CoroutineTestVM : ViewModel() {

  val userDataLiveData = MutableLiveData<List<RoomTestBean>?>()

  val locationInfoLiveData = MutableLiveData<GDLocationBean?>()

  /**
   * MVVM 架构在 ViewMode 中启动协程 默认运行在 UI 线程
   */
  fun selectAllUser() {
    //在Android MVVM架构的viewModel中启动一个新协程（推荐使用），该协程默认运行在UI线程，协程和该组件生命周期绑定，
    //组件销毁时，协程一并销毁，从而实现安全可靠地协程调用。
    //调用viewModelScope.launch{} 或viewModelScope.async{} 方法的时候可以指定运行线程（根据指定的线程来，不指定默认是UI线程）。
    viewModelScope.launch {
      // 查询出所有用户信息
      AppDatabase.getInstance().roomTestDao().getAllRoomTestInfo()
      // 通过第一个人的用户信息查出其他数据
      // TODO kotlin 核心竞争力，简化异步并发任务，以同步的方式完成异步任务
    }
  }

  fun realSelect() {
    viewModelScope.launch {
      // 调用函数为挂起函数，当前协程在主线程执行，挂起函数数据库查询操作自动切换工作线程
      val info = AppDatabase.getInstance().roomTestDao().getAllRoomTestInfo()
      logInfo("realSelect ---- ${Thread.currentThread().name}")
      userDataLiveData.value = info
    }
  }

  fun selectLocation() {
    viewModelScope.launch {
      // 直接执行报错，不能在主线程中执行网络请求
      // val info = RetrofitNet.instance.service.getLocationByGD().execute().body()
      var info : GDLocationBean? = null
      withContext(Dispatchers.IO) {
        info = RetrofitNet.instance.service.getLocationByGD().execute().body()
        logInfo("selectLocation ---- ${Thread.currentThread().name}")
        // 此处不在主线程，只能使用 postValue
        // locationInfoLiveData.value = info
        locationInfoLiveData.postValue(info)
      }

      // 此处手动挂起执行完毕，回到主线程
      // locationInfoLiveData.value = info
      logInfo("selectLocation ---- ${info.toString()} ${Thread.currentThread().name}")
    }
  }

}
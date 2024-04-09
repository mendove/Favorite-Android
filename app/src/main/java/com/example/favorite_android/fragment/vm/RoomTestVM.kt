package com.example.favorite_android.fragment.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_android.db.AppDatabase
import com.example.favorite_android.db.bean.RoomTestBean
import com.example.favorite_android.utils.log.logInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Description:
 * Date: 2024/3/30
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class RoomTestVM : ViewModel() {

  fun addRoomTestInfo(info : RoomTestBean) {
    viewModelScope.launch(Dispatchers.IO) {

      AppDatabase.getInstance().roomTestDao().insert(info)

    }
  }

  fun selectAll() {
    viewModelScope.launch {

      val data = AppDatabase.getInstance().roomTestDao().getAllRoomTestInfo()

      logInfo("${data.toString()}")
    }
  }

}
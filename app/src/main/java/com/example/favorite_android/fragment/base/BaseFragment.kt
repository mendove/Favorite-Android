package com.example.favorite_android.fragment.base

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.favorite_android.utils.log.logInfo
import java.lang.IllegalStateException

/**
 * Description: 基础 Fragment
 * Date: 2023/8/3
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
open class BaseFragment : Fragment() {

  fun initToolbar(toolbar : Toolbar,title : String) {
    toolbar.title = title
    toolbar.setNavigationOnClickListener{
      onBackPressed()
    }
  }

  open fun onBackPressed() {
    var navController: NavController? = null
    try {
      navController = findNavController()
    } catch (e: IllegalStateException) {
      logInfo("onBackPressed ---- $e")
    }

    if (navController?.navigateUp() != true) {
      activity?.finish()
    }
  }


}
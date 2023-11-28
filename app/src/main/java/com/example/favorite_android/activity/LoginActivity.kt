package com.example.favorite_android.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.favorite_android.MainActivity
import com.example.favorite_android.databinding.ActivityLoginBinding
import com.example.favorite_android.handler.SafeRunnable
import com.example.favorite_android.handler.mainSafeDelayed
import com.example.favorite_android.sp.SPOtherUtils

/**
 * Description: 首页登陆 activity
 * Date: 2023/11/8
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
class LoginActivity : AppCompatActivity(){

  private var mViewBinding : ActivityLoginBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
    setContentView(mViewBinding!!.root)
  }

  private fun initView() {
    mViewBinding = ActivityLoginBinding.inflate(layoutInflater)
    mainSafeDelayed(WELCOME_PAGE_TIMEOUT, SafeRunnable{
      mViewBinding!!.root.removeView(mViewBinding!!.welcome)
    })

    mViewBinding!!.btLogin.setOnClickListener {
      val password = mViewBinding!!.etPassword.text.toString()
      if (password == SPOtherUtils.password) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
      } else {
        Toast.makeText(this,"密码错误",Toast.LENGTH_LONG).show()
      }
    }
  }

  companion object {
    const val WELCOME_PAGE_TIMEOUT = 4000L
  }
}
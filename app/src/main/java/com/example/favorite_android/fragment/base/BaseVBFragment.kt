package com.example.favorite_android.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.favorite_android.helper.HandleTestHelper

/**
 * Description: 封装了 ViewBinding 的 Fragment 基类
 * Date: 2023/8/1
 * Author: Shadow
 * Email: 2364306586@qq.com
 */
open class BaseVBFragment<VB : ViewBinding,>(private val vbInflate: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> VB) : BaseFragment(){

    protected var mBinding: VB? = null

    protected val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = vbInflate(inflater, container, false)
        return mBinding!!.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}
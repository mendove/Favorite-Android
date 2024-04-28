package com.example.favorite_android.fragment

import android.os.Bundle
import android.view.View
import com.example.favorite_android.R
import com.example.favorite_android.databinding.FragmentLambdaTestBinding
import com.example.favorite_android.fragment.base.BaseVBVMFragment
import com.example.favorite_android.fragment.viewmodel.LambdaTestVM
import com.example.favorite_android.utils.log.logInfo

/**
 * Description: Lambda 示例
 * Date: 2024/4/10
 * Author: Makka
 * Email: 2364306586@qq.com
 */
class LambdaTestFragment :
  BaseVBVMFragment<FragmentLambdaTestBinding, LambdaTestVM>(FragmentLambdaTestBinding::inflate) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }

  fun initView() {
    initBase(LambdaTestVM::class.java)
    initToolbar(mBinding!!.toolbar, getString(R.string.lambda_test))
  }

  // Lambda 基本形式

  // 1 无参数
  val hello = { logInfo("无参数 Lambda ---- hello") }

  // 等价于
  fun hello() {
    logInfo("无参数 Lambda ---- hello 等价")
  }

  // 2 有参数
  val sum = { a: Int, b: Int -> a + b }

  // lambda 调用方式
  // () 调用
  val result = sum(5, 10)

  // invoke 调用
  val result2 = sum.invoke(3, 5)

  // 3 匿名函数  kotlin 匿名函数实际为一个对象， Lambda 也是一个函数类型的对象
  val sum2 = fun(a: Int, b: Int): Int {
    return a + b
  }

  // 高阶函数

  // 1 引用函数
  // :: 执行函数引用
  fun cal(a: Int, b: Int, f: (a: Int, b: Int) -> Int): Int {
    return f(a, b)
  }

  fun sumCal(a: Int, b: Int): Int {
    return a + b
  }

  fun calRun() {
    // 执行 3 + 5 ::sumCal 表示 sumCal 函数的引用
    val result = cal(3, 5, ::sumCal)
  }

  class Test() {

    fun doSomething() {
      println("引用函数 ---- test")
    }

    fun doTest(f : (Test) -> Unit) {
      f(this)
    }

  }

  fun doTest() {
    val test = Test()
    test.doTest(Test::doSomething)
  }

  // 2 参数 Lambda 化
  fun cal3(a : Int,b :Int, f : (a :Int,b :Int) -> Int) {
    logInfo("参数 Lambda 化  ---- ${f(a,b)}")
  }

  fun cal3Run() {
    // Lambda 直接作为参数传入
    cal3(5,10) { a: Int, b: Int -> a * b }
  }

  data class TestInfo(val name : String,val age : Int)

  // 使用场景，操作集合
  fun testList() {
    val test = listOf(1,3,5,7,9,10,11,12,16)

    // filter函数遍历集合并选出应用给定lambda后会返回true的那些元素
    val more10 = test.filter { it > 10 }

    // map函数对集合中的每一个元素应用给定的函数并把结果收集到一个新集合
    val newList = test.map { it * 5 }

    val testList = listOf(TestInfo("xys", 18), TestInfo("qwe", 12), TestInfo("rty", 10), TestInfo("zxc", 2))

    // 将一个列表转换为另一个列表
    val nameList = testList.map { it.name }

    // filter 与 map 链式操作 取出 age > 10 的 name 新列表
    val nameAgeMore10 = testList.filter { it.age > 10 }.map { it.name }

    // 判断是否全部符合  是否符合全部大于 10
    val all = test.all { it > 10 }

    // 判断是否有符合条件的数据
    val any = test.any { it > 10 }


  }


}
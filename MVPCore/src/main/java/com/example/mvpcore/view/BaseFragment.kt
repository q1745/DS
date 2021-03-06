package com.example.mvpcore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.util.*

abstract class BaseFragment : Fragment() {

    private var baseView:View ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseView = inflater.inflate(getLayoutId(),null,true)
        return baseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initEvent()
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化控件
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 根据ID获取控件
     */
    fun findView(id:Int): View? {
        return baseView?.findViewById<View>(id)
    }

}
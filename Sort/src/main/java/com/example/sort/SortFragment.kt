package com.example.sort

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpcore.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_sort_layout.*

class SortFragment : BaseFragment(){
    override fun initEvent() {

    }

    /**
     * 初始化布局管理器
     */
    override fun initView() {
        sort_first_list_recyclerview.layoutManager = LinearLayoutManager(context)
        sort_second_list_recyclerview.layoutManager = GridLayoutManager(context,3)
    }

    override fun initData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sort_layout
    }

}
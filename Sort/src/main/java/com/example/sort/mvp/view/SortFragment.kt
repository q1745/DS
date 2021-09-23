package com.example.sort.mvp.view

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpcore.view.BaseFragment
import com.example.mvpcore.view.BaseMVPActivity
import com.example.mvpcore.view.MVPFragment
import com.example.sort.R
import com.example.sort.mvp.injection.component.DaggerSortComponent
import com.example.sort.mvp.injection.component.SortComponent
import com.example.sort.mvp.injection.module.ViewModule
import com.example.sort.mvp.presenter.SortPresenter
import kotlinx.android.synthetic.main.fragment_sort_layout.*

class SortFragment : MVPFragment<SortPresenter>(),SortView{

    var sortComponent: SortComponent? = null

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

    override fun initInjection() {

        sortComponent = DaggerSortComponent.builder().activityComponent(activityComponent)
            .viewModule(ViewModule(this))
            .build()
    }

    override fun success(msg: String) {

    }

    override fun failed(throwable: Throwable) {

    }

}
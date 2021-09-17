package com.example.sort.mvp.view

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpcore.view.MVPFragment
import com.example.protocol.BaseReposEntity
import com.example.sort.R
import com.example.sort.adapter.FirstRecAdapter
import com.example.sort.mvp.injection.component.DaggerSortComponent
//import com.example.sort.mvp.injection.component.DaggerSortComponent
import com.example.sort.mvp.injection.component.SortComponent
import com.example.sort.mvp.injection.module.ViewModule
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.presenter.FirstPresenter
import kotlinx.android.synthetic.main.fragment_sort_layout.*
import javax.inject.Inject

class FirstFragment : MVPFragment(),FirstView{


    @Inject
    lateinit var mpresenter:FirstPresenter

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
        sortComponent?.injectSortFragment(this)

        mpresenter?.getList()
    }



    override fun success(bean:BaseReposEntity<FirstEntity>) {
        sort_first_list_recyclerview.adapter = FirstRecAdapter(bean.data)
    }

    override fun failed(throwable: Throwable) {

    }

}
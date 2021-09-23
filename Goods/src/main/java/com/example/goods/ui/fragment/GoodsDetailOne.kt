package com.example.goods.ui.fragment

import com.example.goods.R
import com.example.goods.injection.component.DaggerDetailComponent
import com.example.goods.ui.DetailView
import com.example.mvpcore.view.MVPFragment

class GoodsDetailOne : MVPFragment() , DetailView{
    //Dagger组装
    override fun initInjection() {
        DaggerDetailComponent.builder().activityComponent(activityComponent)
            .build().injectFragment(this)
    }

    override fun initEvent() {
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.goods_detail_layout_one
    }
}
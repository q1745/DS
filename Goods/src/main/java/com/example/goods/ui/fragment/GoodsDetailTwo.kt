package com.example.goods.ui.fragment

import android.util.Log
import com.example.goods.R
import com.example.goods.ui.DetailView
import com.example.mvpcore.view.MVPFragment
import com.example.util.utils.GlideUtils
import kotlinx.android.synthetic.main.goods_detail_layout_two.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class GoodsDetailTwo : MVPFragment(){
    override fun initInjection() {

    }

    override fun initEvent() {
        EventBus.getDefault().register(this)
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.goods_detail_layout_two
    }

    //接收广播
    @Subscribe()
    fun initImageView(images:MutableList<String>){
        Log.i("TAG", "initImageView: ")
        GlideUtils.loadImage(context!!,images.get(0),mGoodsDetailOneIv)
        GlideUtils.loadImage(context!!,images.get(1),mGoodsDetailTwoIv)
    }
}
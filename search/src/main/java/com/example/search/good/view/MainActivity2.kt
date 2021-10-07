package com.example.search.good.view

import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvpcore.view.BaseActivity
import com.example.search.R
import com.example.search.common.*
import com.example.search.good.adapter.GoodsDisAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : BaseActivity(){
    override fun initEvent() {

    }

    override fun initData() {
        goods_rc.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val discountAdapter  = GoodsDisAdapter(this)
        goods_rc.adapter=discountAdapter
        if (discountAdapter != null) {
            discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN
                ,HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN))
        }

        mLeftIv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }

        })
    }

    override fun initView() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main2
    }

}
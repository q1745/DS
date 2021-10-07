package com.example.goods.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.goods.R
import com.example.goods.adapter.GoodsFragmentVpAdapter
import com.example.goods.ui.fragment.GoodsDetailOne
import com.example.goods.ui.fragment.GoodsDetailTwo
import com.example.mvpcore.view.BaseActivity
import com.example.mvpcore.view.BaseMVPActivity
import kotlinx.android.synthetic.main.goods_activity.*

@Route(path = "/Goods/activity")
class GoodsActivity : BaseActivity(){
    @Autowired
    @JvmField
    var goodId : Int = 1


    override fun initEvent() {

    }

    override fun initData() {
        detail_goback.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                this@GoodsActivity.finish()
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前换位原来的布局样式
        setTheme(R.style.Theme_DS)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        goods_activity_tablayout.setTabTextColors(Color.BLACK,Color.WHITE)
        goods_activity_tablayout.setSelectedTabIndicatorColor(Color.WHITE)
        goods_activity_viewpager.adapter = GoodsFragmentVpAdapter(supportFragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        , mutableListOf(GoodsDetailOne(),GoodsDetailTwo()),
            mutableListOf("商品","详情"))
        goods_activity_tablayout.setupWithViewPager(goods_activity_viewpager)

        goods_activity_intocar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@GoodsActivity, "加入成功！", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.goods_activity
    }

    fun getGoodsId() : Int{
        return goodId
    }

}
package com.example.search.good
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.common.BaseApplication.Companion.context

import com.example.mvpcore.view.BaseMVPActivity
import com.example.protocol.BaseReposEntity
import com.example.search.R
import com.example.search.common.*
import com.example.search.good.adapter.GoodsAdapter
import com.example.search.good.adapter.GoodsDisAdapter
import com.example.search.good.injection.DaggerGoodComponet
import com.example.search.good.injection.GoodComponet
import com.example.search.good.injection.ViewModule
import com.example.search.good.model.entity.GoodsEntity
import com.example.search.good.presonter.GoodsPreseonter
import com.example.search.good.view.GoodsView
import kotlinx.android.synthetic.main.activity_good.*
import javax.inject.Inject


/**
@Name:yao
@CreateDate: 2021/9/26 15:01
@ProjectName: DS
@Package: com.example.search.good
@ClassName: GoodActivity
 */
class GoodActivity :BaseMVPActivity(),GoodsView{

    @Inject
    lateinit var goodsPreseonter: GoodsPreseonter
    var goodcompoent:GoodComponet?=null
    lateinit var goodsAdapter: GoodsAdapter

    override fun injectComponent() {
        goodcompoent=DaggerGoodComponet.builder().activityComponent(appComponent)
            .viewModule(ViewModule(this))
            .build()
        goodcompoent!!.injectgoodsComponent(this)
        goodsPreseonter.getGoods(1)
    }

    override fun initEvent() {
        mLeftIv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }

        })
    }

    override fun initData() {
//        val manager = LinearLayoutManager(context)
//        manager.orientation=LinearLayoutManager.HORIZONTAL
        good_rc.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val discountAdapter  = GoodsDisAdapter(context)
        good_rc.adapter=discountAdapter
        if (discountAdapter != null) {
            discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN
                ,HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN))
        }

    }

    override fun initView() {
        good_rc.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_good
    }

    override fun goodsSuccess(entity: BaseReposEntity<GoodsEntity>) {
        goodsAdapter= GoodsAdapter(entity.data)
        good_rc.adapter=goodsAdapter
    }

    override fun goodsFailed(throwable: Throwable) {
        
    }


}
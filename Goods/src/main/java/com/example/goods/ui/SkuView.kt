package com.example.goods.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.example.goods.R
import com.example.goods.service.entity.GoodsSku
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.skuview_layout.view.*


/**
 * @JvmOverloads暴露多个重载方法
 */
class SkuView @JvmOverloads constructor(context: Context, attrs:AttributeSet? = null, defStyle:Int = 0) : FrameLayout(context,attrs,defStyle) {
    private lateinit var mGoodsSku:GoodsSku

    init {
        View.inflate(context,R.layout.skuview_layout,null)
    }

    fun setSkuView(goodsSku:GoodsSku){
        mGoodsSku = goodsSku
        goodsSku.skuContent = listOf("Core i5/8G内存/128G闪存", "Core i5/8G内存/256G闪存")
        mSkuViewTv.text = goodsSku.skuTitle
        SkuView_TagFlowLayout.adapter =object : TagAdapter<String>(goodsSku.skuContent){
            override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.skuview_tag_item_layout, null) as TextView
                view.text = t
                return view
            }
        }
    }
}
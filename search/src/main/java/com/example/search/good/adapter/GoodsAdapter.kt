package com.example.search.good.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.search.R
import com.example.search.good.model.entity.GoodsEntity
import com.example.util.utils.GlideUtils

/**
@Name:yao
@CreateDate: 2021/9/27 16:37
@ProjectName: DS
@Package: com.example.search.good.adapter
@ClassName: GoodsAdapter
 */
class GoodsAdapter(list: MutableList<GoodsEntity>):
    BaseQuickAdapter<GoodsEntity,BaseViewHolder>(R.layout.good_item,list) {
    override fun convert(holder: BaseViewHolder, item: GoodsEntity) {
        GlideUtils.loadImage(context,item.goodsDefaultIcon,holder.getView(R.id.im_goods))
        holder.getView<TextView>(R.id.shop_item_name).text=item.goodsDesc
        holder.getView<TextView>(R.id.shop_item_num).text=item.goodsDefaultPrice.toString()
        holder.getView<TextView>(R.id.shop_item_money).text=item.goodsStockCount.toString()
    }
}
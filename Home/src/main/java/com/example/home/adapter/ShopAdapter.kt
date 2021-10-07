package com.example.home.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.home.R
import com.example.home.mvp.model.entity.ShopEntity
import com.example.util.utils.GlideUtils

class ShopAdapter (list: MutableList<ShopEntity>) :
    BaseQuickAdapter<ShopEntity, BaseViewHolder>(R.layout.shop_list_item,list) {
    override fun convert(holder: BaseViewHolder, item: ShopEntity) {
        GlideUtils.loadImage(context,item.goodsDefaultIcon,holder.getView(R.id.shop_item_img))
        holder.getView<TextView>(R.id.shop_item_name).text=item.goodsDesc
        holder.getView<TextView>(R.id.shop_item_num).text=item.goodsDefaultPrice.toString()
        holder.getView<TextView>(R.id.shop_item_money).text=item.goodsStockCount.toString()
    }

}
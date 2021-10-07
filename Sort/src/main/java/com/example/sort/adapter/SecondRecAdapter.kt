package com.example.sort.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.sort.R
import com.example.sort.mvp.model.entity.SecondEntity
import com.example.util.utils.GlideUtils

class SecondRecAdapter(list: MutableList<SecondEntity>) :
    BaseQuickAdapter<SecondEntity, BaseViewHolder>(R.layout.second_item_layout,list) {
    override fun convert(holder: BaseViewHolder, item: SecondEntity) {
        holder.setText(R.id.second_item_name,item.categoryName)
        GlideUtils.loadImage(context,item.categoryIcon,holder.getView(R.id.second_item_img))
    }
}
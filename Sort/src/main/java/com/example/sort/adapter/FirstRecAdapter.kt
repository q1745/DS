package com.example.sort.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.sort.R
import com.example.sort.mvp.model.entity.FirstEntity

/**
 * 分类条目的Adapter
 */
class FirstRecAdapter(data : MutableList<FirstEntity>)
    : BaseQuickAdapter<FirstEntity,BaseViewHolder>(
    R.layout.first_item_false_layout,data
){
    override fun convert(holder: BaseViewHolder, item: FirstEntity) {
        holder.setText(R.id.first_item_TextView,item.categoryName)
    }
}
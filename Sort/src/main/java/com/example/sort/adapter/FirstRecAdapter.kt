package com.example.sort.adapter

import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.sort.MyApplication
import com.example.sort.R
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.SecondEntity

/**
 * 分类条目的Adapter
 */
class FirstRecAdapter(data: MutableList<FirstEntity>)
    : BaseQuickAdapter<FirstEntity,BaseViewHolder>(
    R.layout.first_item_false_layout,data
){
    override fun convert(holder: BaseViewHolder, item: FirstEntity) {
        holder.setText(R.id.first_item_TextView,item.categoryName)
        val text = holder.getView<TextView>(R.id.first_item_TextView)
        //判断选中属性是否为true，为ture文字颜色为黄色
        if (item.isSelected) {
            text.setTextColor(Color.parseColor("#FE9C2F"))
        } else{
            text.setTextColor(Color.parseColor("#D3000000"))
        }
    }
}
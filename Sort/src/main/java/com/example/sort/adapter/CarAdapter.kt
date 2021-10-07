package com.example.sort.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.protocol.BaseReposEntity
import com.example.sort.R
import com.example.sort.mvp.model.entity.CarEntity
import com.example.util.utils.GlideUtils

/**
@CreateDate: 2021/9/23 18:57
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.adapter
@ClassName: CarAdapter
 */
class CarAdapter(list: BaseReposEntity<CarEntity>): BaseQuickAdapter<CarEntity, BaseViewHolder>(R.layout.car_view_show) {
    override fun convert(holder: BaseViewHolder, item: CarEntity) {
        GlideUtils.loadImage(context,item.goodsIcon,holder.getView(R.id.car_view_image))
    }
}
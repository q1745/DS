package com.example.sort.mvp.model.entity

/**
@CreateDate: 2021/9/23 15:54
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.model.entity
@ClassName: CarEntity
 */
data class CarEntity(
    val id: Int,//购物车单项商品ID
    val goodsId:Int,//具体商品ID
    val goodsDesc: String,//商品描述
    val goodsIcon: String,//商品图片
    val goodsPrice: Long,//商品价格
    var goodsCount: Int,//商品数量
    val goodsSku:String,//商品SKU
    var isSelected:Boolean//是否选中
)

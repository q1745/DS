package com.example.search.good.model.entity

/**
@Name:yao
@CreateDate: 2021/9/27 10:29
@ProjectName: DS
@Package: com.example.search.good.model.entity
@ClassName: GoodsEntity
 */
class GoodsEntity (
    val id: Int,//商品ID
    val categoryId: Int,//分类ID
    val goodsDesc: String,//商品描述
    val goodsDefaultIcon: String,//默认图标
    val goodsDefaultPrice: Long,//默认价格
    val goodsDetailOne: String,//商品详情一图
    val goodsDetailTwo: String,//商品详情二图
    val goodsSalesCount: Int,//商品销量
    val goodsStockCount: Int,//商品剩余量
    val goodsCode: String,//商品编号
    val goodsDefaultSku: String,//默认SKU
    val goodsBanner: String,//商品banner图
    val maxPage:Int//最大页码
)
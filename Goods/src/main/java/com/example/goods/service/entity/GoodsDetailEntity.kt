package com.example.goods.service.entity

data class GoodsDetailEntity(
    val categoryId: Int,
    val goodsBanner: String,
    val goodsCode: String,
    val goodsDefaultIcon: String,
    val goodsDefaultPrice: String,
    val goodsDefaultSku: String,
    val goodsDesc: String,
    val goodsDetailOne: String,
    val goodsDetailTwo: String,
    val goodsSalesCount: Int,
    val goodsSku: List<GoodsSku>,
    val goodsStockCount: Int,
    val id: Int
)


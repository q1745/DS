package com.example.sort.mvp.model.entity

data class SecondEntity(
    val id: Int, //分类ID
    val categoryName: String, //分类名称
    val categoryIcon: String = "", //分类图标
    val parentId: Int, //分类 父级ID
    var isSelected: Boolean = false//是否被选中
)

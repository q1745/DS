package com.example.sort.mvp.model.entity

data class FirstEntity(val id: Int, //分类ID
                       val categoryName: String, //分类名称
                       var isSelected: Boolean = false//是否被选中
)

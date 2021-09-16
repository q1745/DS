package com.example.ds

data class Bean(
    val data: List<Data>,
    val message: String,
    val status: Int
)

data class Data(
    val categoryIcon: String,
    val categoryName: String,
    val id: Int,
    val parentId: Int
)
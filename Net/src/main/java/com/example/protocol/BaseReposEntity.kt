package com.example.protocol

data class BaseReposEntity<T>(var code:Int,var data:MutableList<T>,var msg:String) {
}
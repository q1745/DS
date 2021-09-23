package com.example.home.mvp.view

import com.example.home.mvp.model.entity.ShopEntity
import com.example.mvpcore.IView
import com.example.protocol.BaseReposEntity

interface ShopView : IView{
    fun shopSuccess(entity : BaseReposEntity<ShopEntity>)

    fun shopFailed(throwable: Throwable)
}
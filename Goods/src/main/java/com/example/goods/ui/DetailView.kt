package com.example.goods.ui

import com.example.goods.service.entity.GoodsDetailEntity
import com.example.mvpcore.IView

interface DetailView : IView {

    fun success(bean : GoodsDetailEntity)

    fun failed(throwable: Throwable)
}
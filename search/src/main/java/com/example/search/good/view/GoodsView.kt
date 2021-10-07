package com.example.search.good.view

import com.example.mvpcore.IView
import com.example.protocol.BaseReposEntity
import com.example.search.good.model.entity.GoodsEntity

/**
@Name:yao
@CreateDate: 2021/9/27 10:33
@ProjectName: DS
@Package: com.example.search.good.view
@ClassName: GoodsView
 */
interface GoodsView :IView {
    fun goodsSuccess(entity : BaseReposEntity<GoodsEntity>)

    fun goodsFailed(throwable: Throwable)
}
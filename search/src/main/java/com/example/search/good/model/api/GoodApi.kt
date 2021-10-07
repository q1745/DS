package com.example.search.good.model.api

import com.example.protocol.BaseReposEntity
import com.example.search.good.model.entity.GoodsEntity
import com.example.search.good.model.entity.GoodsRequestEntity
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.Body
import retrofit2.http.POST

/**
@Name:yao
@CreateDate: 2021/9/27 10:27
@ProjectName: DS
@Package: com.example.search.good.model
@ClassName: GoodApi
 */
interface GoodApi {
    @POST("goods/getGoodsList")
    fun getGoods(@Body a: GoodsRequestEntity) :Observable<BaseReposEntity<GoodsEntity>>
}
package com.example.home.mvp.model.api

import com.example.home.mvp.model.entity.ShopEntity
import com.example.home.mvp.model.entity.ShopRequestEntity
import com.example.protocol.BaseReposEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopApi {

    @POST("goods/getGoodsList")
    fun getShop(@Body a : ShopRequestEntity): Observable<BaseReposEntity<ShopEntity>>
}
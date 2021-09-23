package com.example.goods.service.api

import com.example.goods.service.entity.GoodsDetailEntity
import com.example.goods.service.entity.RequestEntity
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface DetailApi {


    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body body : RequestEntity) : Observable<BaseReposDataEntity<GoodsDetailEntity>>
}
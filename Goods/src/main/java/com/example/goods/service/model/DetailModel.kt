package com.example.goods.service.model

import com.example.goods.service.api.DetailApi
import com.example.goods.service.entity.GoodsDetailEntity
import com.example.goods.service.entity.RequestEntity
import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 请求商品你详情
 */
class DetailModel : IModel {

    fun getGoodsDetail(goodsId:Int,observer: Observer<BaseReposDataEntity<GoodsDetailEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(DetailApi::class.java)
            .getGoodsDetail(RequestEntity(goodsId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
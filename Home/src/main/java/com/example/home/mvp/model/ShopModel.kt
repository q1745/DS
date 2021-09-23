package com.example.home.mvp.model

import com.example.home.mvp.model.api.ShopApi
import com.example.home.mvp.model.entity.ShopEntity
import com.example.home.mvp.model.entity.ShopRequestEntity
import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ShopModel : IModel{

    fun getShop(categoryId: Int, pageNo: Int, observer: Observer<BaseReposEntity<ShopEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(ShopApi::class.java)
            .getShop(ShopRequestEntity(categoryId, pageNo))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
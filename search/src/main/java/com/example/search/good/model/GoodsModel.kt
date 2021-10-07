package com.example.search.good.model

import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import com.example.search.good.model.api.GoodApi
import com.example.search.good.model.entity.GoodsEntity
import com.example.search.good.model.entity.GoodsRequestEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
@Name:yao
@CreateDate: 2021/9/27 10:33
@ProjectName: DS
@Package: com.example.search.good.model
@ClassName: GoodsModel
 */
class GoodsModel :IModel{

    fun getgoods(categoryId: Int, pageNo: Int, observer: Observer<BaseReposEntity<GoodsEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(GoodApi::class.java)
            .getGoods(GoodsRequestEntity(categoryId,pageNo))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
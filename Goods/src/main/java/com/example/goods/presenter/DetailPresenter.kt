package com.example.goods.presenter

import android.util.Log
import com.example.goods.repository.DetailRepository
import com.example.goods.service.entity.GoodsDetailEntity
import com.example.goods.ui.fragment.GoodsDetailOne
import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class DetailPresenter @Inject constructor() : BasePresenter<GoodsDetailOne, DetailRepository>() {

    fun getGoodsDetail(goodsId:Int){
        repository.getGoodsDetail(goodsId,object : Observer<BaseReposDataEntity<GoodsDetailEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseReposDataEntity<GoodsDetailEntity>) {
                view.success(t.data)
            }

            override fun onError(e: Throwable) {
                view.failed(e)
            }

            override fun onComplete() {

            }
        })
    }
}
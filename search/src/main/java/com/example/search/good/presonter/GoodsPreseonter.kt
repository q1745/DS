package com.example.search.good.presonter

import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposEntity
import com.example.search.good.model.entity.GoodsEntity
import com.example.search.good.repository.GoodsRepository
import com.example.search.good.view.GoodsView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
@Name:yao
@CreateDate: 2021/9/27 16:21
@ProjectName: DS
@Package: com.example.search.good.presonter
@ClassName: GoodsPreseonter
 */
class GoodsPreseonter @Inject constructor() :BasePresenter<GoodsView,GoodsRepository>(){

    @Inject
    lateinit var goodsRepository: GoodsRepository

    fun getGoods(pageNo:Int){
        goodsRepository.getGood(14,1,object :Observer<BaseReposEntity<GoodsEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseReposEntity<GoodsEntity>) {
                view.goodsSuccess(t)
            }

            override fun onError(e: Throwable) {
               view.goodsFailed(e)
            }

            override fun onComplete() {

            }

        })
    }
}
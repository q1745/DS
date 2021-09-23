package com.example.home.mvp.presenter

import com.example.home.mvp.model.entity.ShopEntity
import com.example.home.mvp.repository.ShopRepository
import com.example.home.mvp.view.ShopView
import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ShopPresenter @Inject constructor(): BasePresenter<ShopView, ShopRepository>(){

    @Inject
    lateinit var shopRepository: ShopRepository

    fun getShop(pageNo: Int) {
        shopRepository.getShop(14, 1 ,object : Observer<BaseReposEntity<ShopEntity>> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: BaseReposEntity<ShopEntity>) {
                view.shopSuccess(t)
            }

            override fun onError(e: Throwable) {
                view.shopFailed(e)
            }

            override fun onComplete() {
            }
        })
    }
}
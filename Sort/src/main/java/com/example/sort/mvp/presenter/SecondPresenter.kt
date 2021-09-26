package com.example.sort.mvp.presenter

import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.api.SecondApi
import com.example.sort.mvp.model.entity.FirstEntity

import com.example.sort.mvp.model.entity.SecondEntity
import com.example.sort.mvp.repository.SecondRepository
import com.example.sort.mvp.view.SecondView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SecondPresenter @Inject constructor(): BasePresenter<SecondView, SecondRepository>(){

    @Inject
    lateinit var secondRepository: SecondRepository

    fun getSecondList(parentId: Int) {
        secondRepository.second(parentId,object : Observer<BaseReposEntity<SecondEntity>> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: BaseReposEntity<SecondEntity>) {
               view.secondSuccess(t)
            }

            override fun onError(e: Throwable) {
                view.secondFailed(e)
            }

            override fun onComplete() {
            }
        })
    }
}
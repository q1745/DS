package com.example.sort.mvp.presenter

import android.util.Log
import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.repository.FirstRepository
import com.example.sort.mvp.view.FirstView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class FirstPresenter @Inject constructor() : BasePresenter<FirstView,FirstRepository>() {
    fun getList(){
        repository.sortList(object : Observer<BaseReposEntity<FirstEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseReposEntity<FirstEntity>) {
                view.success(t)
            }

            override fun onError(e: Throwable) {
                view.failed(e)
            }

            override fun onComplete() {
            }

        })
    }
}
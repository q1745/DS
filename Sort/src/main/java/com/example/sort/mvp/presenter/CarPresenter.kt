package com.example.sort.mvp.presenter

import android.util.Log
import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.CarEntity
import com.example.sort.mvp.repository.CarRepository
import com.example.sort.mvp.view.CarView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
@CreateDate: 2021/9/23 16:00
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.presenter
@ClassName: CarPresenter
 */
class CarPresenter @Inject constructor(): BasePresenter<CarView, CarRepository>() {
    fun getList(){
        repository.success(object :Observer<BaseReposEntity<CarEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseReposEntity<CarEntity>) {
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
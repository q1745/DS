package com.example.sort.mvp.model

import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.api.SecondApi
import com.example.sort.mvp.model.entity.SecondEntity
import com.example.sort.mvp.model.entity.SecondRequsetEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SecondModel @Inject constructor() : IModel{

    fun second(parentId: Int, observer: Observer<BaseReposEntity<SecondEntity>>) {
        RetrofitFactory.retrofitFactory.retrofit
            .create(SecondApi::class.java)
            .second(SecondRequsetEntity(parentId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
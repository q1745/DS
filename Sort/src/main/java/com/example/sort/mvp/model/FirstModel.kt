package com.example.sort.mvp.model

import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.api.FirstApi
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.FirstRequestEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FirstModel : IModel{

    fun sortList(observer: Observer<BaseReposEntity<FirstEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(FirstApi::class.java)
            .sortList(FirstRequestEntity("0"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
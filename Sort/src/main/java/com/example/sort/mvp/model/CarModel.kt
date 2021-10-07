package com.example.sort.mvp.model

import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.api.CarApi
import com.example.sort.mvp.model.entity.CarEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

/**
@CreateDate: 2021/9/23 16:27
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.model
@ClassName: CarModel
 */
class CarModel:IModel {
    fun carList(observer: Observer<BaseReposEntity<CarEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(CarApi::class.java)
            .carList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
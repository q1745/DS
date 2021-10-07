package com.example.live.mvp.model

import com.example.live.mvp.model.api.LiveApi
import com.example.live.mvp.model.entity.LiveEntity
import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import io.reactivex.Observable
import io.reactivex.Observer

/**
@CreateDate: 2021/9/26 8:37
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.live.mvp.model
@ClassName: LiveModel
 */
class LiveModel : IModel {
    fun getLiveList(observer: Observer<BaseReposEntity<LiveEntity>>){
        RetrofitFactory.retrofitFactory.retrofit.create(LiveApi::class.java)
    }
}
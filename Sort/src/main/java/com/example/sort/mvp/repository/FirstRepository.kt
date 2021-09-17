package com.example.sort.mvp.repository

import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.FirstModel
import com.example.sort.mvp.model.entity.FirstEntity
import io.reactivex.Observer
import javax.inject.Inject

class FirstRepository @Inject constructor() : BaseRepository() {

    fun sortList(observer: Observer<BaseReposEntity<FirstEntity>>){
        (models.get("remoteModel") as FirstModel)!!.sortList(observer)
    }
}
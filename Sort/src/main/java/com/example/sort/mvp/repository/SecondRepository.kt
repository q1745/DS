package com.example.sort.mvp.repository

import com.example.mvpcore.BaseRepository
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.SecondModel
import com.example.sort.mvp.model.entity.SecondEntity
import io.reactivex.Observer
import javax.inject.Inject

class SecondRepository @Inject constructor() : BaseRepository() {

    fun second(parentId: Int, observer: Observer<BaseReposEntity<SecondEntity>>){
        (models.get("SecondremoteModel") as SecondModel).second(parentId,observer)
    }
}
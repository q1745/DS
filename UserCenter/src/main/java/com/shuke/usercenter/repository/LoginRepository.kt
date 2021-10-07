package com.shuke.usercenter.repository

import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import com.shuke.usercenter.model.entity.login.LoginReq
import com.shuke.usercenter.model.entity.login.UserInfo
import com.shuke.usercenter.model.server.LoginModel
import io.reactivex.Observer
import javax.inject.Inject

class LoginRepository @Inject constructor() : BaseRepository() {

    fun login(loginreq: LoginReq, observer: Observer<BaseReposDataEntity<UserInfo>>){
        (models.get("LoginModel") as LoginModel).login(loginreq,observer)
    }
}
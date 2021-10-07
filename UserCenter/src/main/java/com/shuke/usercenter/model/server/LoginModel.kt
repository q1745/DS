package com.shuke.usercenter.model.server

import com.example.mvpcore.IModel
import com.example.net.RetrofitFactory
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import com.shuke.usercenter.model.api.UserCenterApi
import com.shuke.usercenter.model.entity.login.LoginReq
import com.shuke.usercenter.model.entity.login.UserInfo
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModel : IModel {
    fun login(loginreq: LoginReq, observer: Observer<BaseReposDataEntity<UserInfo>>){
        RetrofitFactory.retrofitFactory.retrofit.create(UserCenterApi::class.java)
            .Login(loginreq)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}
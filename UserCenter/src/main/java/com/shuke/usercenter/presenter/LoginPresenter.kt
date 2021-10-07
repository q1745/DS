package com.shuke.usercenter.presenter

import com.example.mvpcore.BasePresenter
import com.example.protocol.BaseReposDataEntity
import com.shuke.usercenter.model.entity.login.LoginReq
import com.shuke.usercenter.model.entity.login.UserInfo
import com.shuke.usercenter.repository.LoginRepository
import com.shuke.usercenter.view.LoginActivity
import com.shuke.usercenter.view.LoginView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class LoginPresenter @Inject constructor() : BasePresenter<LoginActivity, LoginRepository>() {

    fun login(loginReq: LoginReq){
        repository.login(loginReq,object : Observer<BaseReposDataEntity<UserInfo>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseReposDataEntity<UserInfo>) {
                view.success(t.data)
            }

            override fun onError(e: Throwable) {
                view.failed(e)
            }

            override fun onComplete() {

            }

        })
    }
}
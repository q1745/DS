package com.shuke.usercenter.model.api

import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import com.shuke.usercenter.model.entity.login.LoginReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserCenterApi {

    /**
     * 登录
     */
    @POST("userCenter/login")
    fun Login(@Body loginRqe:LoginReq) : Observable<BaseReposDataEntity<LoginReq>>

}
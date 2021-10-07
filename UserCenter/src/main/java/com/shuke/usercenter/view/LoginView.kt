package com.shuke.usercenter.view

import com.example.mvpcore.IView
import com.shuke.usercenter.model.entity.login.UserInfo

interface LoginView : IView {


    fun success(bean: UserInfo)

    fun failed(e : Throwable)
}
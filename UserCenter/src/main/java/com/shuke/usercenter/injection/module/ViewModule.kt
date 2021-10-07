package com.shuke.usercenter.injection.module

import com.shuke.usercenter.view.LoginActivity
import dagger.Module
import dagger.Provides



@Module
class ViewModule(var view:LoginActivity) {

    @Provides
    fun provideView():LoginActivity{
        return view
    }
}
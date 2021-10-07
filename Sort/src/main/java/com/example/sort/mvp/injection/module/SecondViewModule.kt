package com.example.sort.mvp.injection.module

import com.example.sort.mvp.model.entity.SecondEntity
import com.example.sort.mvp.view.SecondView
import dagger.Module
import dagger.Provides

@Module
class SecondViewModule (var secondView: SecondView){

    @Provides
    fun providesSecondView(): SecondView {
        return secondView
    }
}
package com.example.sort.mvp.injection.module

import com.example.sort.mvp.view.CarView
import dagger.Module
import dagger.Provides

/**
@CreateDate: 2021/9/24 8:51
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.injection.module
@ClassName: CarViewModule
 */
@Module
class CarViewModule(var view:CarView) {
    @Provides
    fun  getCarView():CarView{
        return view
    }
}
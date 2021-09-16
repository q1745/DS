package com.example.mvpcore.view

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import com.example.di.BaseApp
import com.example.di.component.ActivityComponent
import com.example.di.component.DaggerActivityComponent
import com.example.di.module.ActivityModule
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.annotation.Presenter
import javax.inject.Inject

/**
 * 基于MVP框架的Activity的基类
 * 利用注解+反射实现对应多个Presenter
 */
abstract class BaseMVPActivity<P : BasePresenter<*,*>> : BaseActivity(){

    @Inject
    protected lateinit var presenter:P

    protected var build: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        build = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .appComponent((application as BaseApp).daggerAppComponent).build()

        injectComponent()
    }

    /**
     * Dagger组装
     */
    abstract fun injectComponent()

}
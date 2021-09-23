package com.example.mvpcore.view

import android.os.Bundle
import android.view.View
import com.example.di.BaseApp
import com.example.di.component.ActivityComponent
import com.example.di.component.DaggerActivityComponent
import com.example.di.module.ActivityModule
import com.example.mvpcore.BasePresenter
import javax.inject.Inject

abstract class MVPFragment<P : BasePresenter<*,*>> : BaseFragment(){

    @Inject
    protected lateinit var presenter:P

    protected var activityComponent: ActivityComponent? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
            .appComponent((activity!!.application as BaseApp).daggerAppComponent)
            .activityModule(ActivityModule(activity!!))
            .build()
        initInjection()
    }

    abstract fun initInjection()

}
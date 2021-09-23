package com.example.mvpcore.view

import android.os.Bundle
import android.view.View
import com.example.di.BaseApp
import com.example.di.component.ActivityComponent
import com.example.di.component.DaggerActivityComponent
import com.example.di.module.ActivityModule


abstract class MVPFragment : BaseFragment(){


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
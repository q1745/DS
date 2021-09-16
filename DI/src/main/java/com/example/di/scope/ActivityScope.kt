package com.example.di.scope

import javax.inject.Scope

/**
 * Activity的作用域
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope()

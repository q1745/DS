package com.example.di.scope

import java.lang.annotation.ElementType
import java.lang.annotation.Target
import javax.inject.Scope

/**
 * Activity的作用域
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(ElementType.TYPE, ElementType.METHOD)
annotation class ActivityScope()

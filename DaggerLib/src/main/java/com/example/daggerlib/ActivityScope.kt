package com.example.daggerlib

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Activity 的 Scope（作用域）
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope()

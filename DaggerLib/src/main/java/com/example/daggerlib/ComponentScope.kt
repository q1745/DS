package com.example.daggerlib

import javax.inject.Scope

/**
 * 组件级别的Scope（作用域）
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ComponentScope()

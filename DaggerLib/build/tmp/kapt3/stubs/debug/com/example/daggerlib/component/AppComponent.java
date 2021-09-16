package com.example.daggerlib.component;

import java.lang.System;

/**
 * Application 的 Component（桥梁）
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/daggerlib/component/AppComponent;", "", "context", "Landroid/content/Context;", "DaggerLib_debug"})
@dagger.Component(modules = {com.example.daggerlib.module.AppModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context context();
}
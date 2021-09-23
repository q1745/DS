package com.example.ds

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import com.tencent.bugly.crashreport.CrashReport
import android.content.pm.PackageManager

import android.os.Bundle

import android.content.pm.ActivityInfo

import android.content.pm.PackageInfo
import android.os.Process
import com.alibaba.sdk.android.cloudcode.CloudCodeInitializer
import com.alibaba.sdk.android.cloudcode.CloudCodeLog
import com.alibaba.sdk.android.logger.LogLevel
import com.example.common.BaseApplication
import com.example.di.BaseApp


class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        Thread(object : Runnable {
            override fun run() {
                //降低优先级为10，相当于后台线程
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)

                CrashReport.initCrashReport(getApplicationContext(), "c61680ee5e", true);

                // 用户签署隐私协议之后，
                // 注入用户设备OAID
                CloudCodeInitializer.setOAID("用户设备oaid")
                // 调用云码sdk初始化
                CloudCodeInitializer.init(this@App)
                // 如果没有在manifest中配置渠道ID和媒体ID，需要在此处传入
                // CloudCodeInitializer.init(this, "使用渠道ID替换此处", "使用媒体ID替换此处");
                // 设置日志输出级别为debug
                CloudCodeLog.setLevel(LogLevel.DEBUG)
            }

        })
    }




}
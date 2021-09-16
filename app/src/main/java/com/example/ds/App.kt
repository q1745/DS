package com.example.ds

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(getApplicationContext(), "c61680ee5e", true);
    }
}
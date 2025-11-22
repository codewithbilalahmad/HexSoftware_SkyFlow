package com.muhammad.skyflow

import android.app.Application
import com.muhammad.skyflow.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SkyFlowApplication : Application(){
    companion object{
        lateinit var INSTANCE : SkyFlowApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE= this
        startKoin {
            androidContext(this@SkyFlowApplication)
            androidLogger()
            modules(appModule)
        }
    }
}
package com.fluttx.memecraft

import android.app.Application
import com.fluttx.memecraft.di.initKoin
import org.koin.android.ext.koin.androidContext

class MemeCraftApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MemeCraftApplication)
        }
    }
}
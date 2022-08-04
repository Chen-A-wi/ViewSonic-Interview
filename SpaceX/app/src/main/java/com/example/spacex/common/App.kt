package com.example.spacex.common

import android.app.Application
import com.example.spacex.di.diModules
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        startKoin {
            androidContext(this@App)
            modules(diModules)
        }
    }
}
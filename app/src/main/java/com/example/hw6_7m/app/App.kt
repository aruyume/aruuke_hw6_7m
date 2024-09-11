package com.example.hw6_7m.app

import android.app.Application
import com.example.data.di.dataModules
import com.example.domain.di.useCaseModule
import com.example.hw6_7m.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
            modules(dataModules)
            modules(useCaseModule)
        }
    }
}
package com.example.cryptocurrency

import android.app.Application
import com.example.cryptocurrency.di.module.apiModule
import com.example.cryptocurrency.di.module.googleModule
import com.example.cryptocurrency.di.module.repositoriesModule
import com.example.cryptocurrency.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(listOf(googleModule,viewModelModule, apiModule, repositoriesModule))
        }
    }
}
package com.example.andi.uitests

import android.app.Application
import com.example.andi.uitests.koin.AppModules
import org.koin.android.ext.android.releaseProperties
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.android.startKoin

class UiTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, AppModules.modules)
        setProperty("application-context", applicationContext)

    }

    override fun onTerminate() {
        super.onTerminate()
        releaseProperties("application-context")
    }
}
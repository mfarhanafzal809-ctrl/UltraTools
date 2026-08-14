package com.ultratools.app

import android.app.Application
import com.ultratools.app.core.config.AppConfiguration

class UltraToolsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppConfiguration.initialize(
            applicationContext = applicationContext
        )
    }
}

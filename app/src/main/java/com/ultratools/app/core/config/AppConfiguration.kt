package com.ultratools.app.core.config

import android.content.Context

object AppConfiguration {

    @Volatile
    private var initialized = false

    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        if (initialized) return

        synchronized(this) {
            if (initialized) return

            applicationContext = context.applicationContext
            initialized = true
        }
    }

    fun context(): Context {
        check(initialized) {
            "AppConfiguration has not been initialized."
        }

        return applicationContext
    }
}

package com.euphony.waple

import android.app.Application
import android.content.Context

class WapleApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: WapleApplication

        fun getContext(): Context {
            return instance.applicationContext
        }
    }
}
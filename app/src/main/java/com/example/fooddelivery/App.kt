package com.example.fooddelivery

import android.app.Application
import android.content.Context
import com.example.fooddelivery.ioc.ApplicationComponent

class App : Application() {

    val applicationComponent by lazy { ApplicationComponent(applicationContext) }

    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }
}
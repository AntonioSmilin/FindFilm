package com.tonykuz.findfilm

import android.app.Application
import com.tonykuz.findfilm.di.AppComponent
import com.tonykuz.findfilm.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
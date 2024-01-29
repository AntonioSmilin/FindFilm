package com.tonykuz.findfilm

import android.app.Application
import com.tonykuz.findfilm.di.AppComponent
import com.tonykuz.findfilm.di.DaggerAppComponent
import com.tonykuz.findfilm.di.modules.DatabaseModule
import com.tonykuz.findfilm.di.modules.DomainModule
import com.tonykuz.findfilm.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
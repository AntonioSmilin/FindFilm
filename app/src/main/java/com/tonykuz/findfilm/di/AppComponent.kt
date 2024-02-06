package com.tonykuz.findfilm.di

import com.tonykuz.findfilm.di.modules.DatabaseModule
import com.tonykuz.findfilm.di.modules.DomainModule
import com.tonykuz.findfilm.di.modules.RemoteModule
import com.tonykuz.findfilm.viewmodel.HomeFragmentViewModel
import com.tonykuz.findfilm.viewmodel.SettingsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}
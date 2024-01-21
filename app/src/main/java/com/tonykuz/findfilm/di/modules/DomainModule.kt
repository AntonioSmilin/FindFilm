package com.tonykuz.findfilm.di.modules

import com.tonykuz.findfilm.data.MainRepository
import com.tonykuz.findfilm.data.TmdbApi
import com.tonykuz.findfilm.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}
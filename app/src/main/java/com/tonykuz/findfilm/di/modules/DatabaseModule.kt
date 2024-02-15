package com.tonykuz.findfilm.di.modules

import android.content.Context
import androidx.room.Room
import com.tonykuz.findfilm.data.MainRepository
import com.tonykuz.findfilm.data.dao.FilmDao
import com.tonykuz.findfilm.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}
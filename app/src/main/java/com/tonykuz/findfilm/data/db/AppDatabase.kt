package com.tonykuz.findfilm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tonykuz.findfilm.data.Entity.Film
import com.tonykuz.findfilm.data.dao.FilmDao

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}
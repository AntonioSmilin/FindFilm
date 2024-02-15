package com.tonykuz.findfilm.data

//import android.content.ContentValues
//import android.database.Cursor
//import com.tonykuz.findfilm.data.db.DatabaseHelper
import androidx.lifecycle.LiveData
import com.tonykuz.findfilm.data.Entity.Film
import com.tonykuz.findfilm.data.dao.FilmDao
import java.util.concurrent.Executors


class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> = filmDao.getCachedFilms()

    //Версия до 41 модуля
    //fun getAllFromDB(): List<Film> {
    //    return filmDao.getCachedFilms()
    }
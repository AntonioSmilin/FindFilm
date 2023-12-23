package com.tonykuz.findfilm.domain

import com.tonykuz.findfilm.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}
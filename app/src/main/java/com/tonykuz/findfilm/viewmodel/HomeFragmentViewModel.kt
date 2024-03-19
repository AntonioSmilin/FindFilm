package com.tonykuz.findfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykuz.findfilm.App
import com.tonykuz.findfilm.data.Entity.Film
import com.tonykuz.findfilm.domain.Interactor
import java.util.concurrent.Executors
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {
    val showProgressBar: MutableLiveData<Boolean> = MutableLiveData()

    //val filmsListLiveData: MutableLiveData<List<Film>> = MutableLiveData()

    //Инициализируем интерактор

    @Inject
    lateinit var interactor: Interactor
    val filmsListLiveData: LiveData<List<Film>>

    init {
        App.instance.dagger.inject(this)
        filmsListLiveData = interactor.getFilmsFromDB()
        getFilms()

    //Версия до 41 модуля
    //@Inject
    //lateinit var interactor: Interactor

    //init {
    //    App.instance.dagger.inject(this)
    //    getFilms()
    }

    fun getFilms() {
        showProgressBar.postValue(true)
        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess() {
                showProgressBar.postValue(false)
            }

            override fun onFailure() {
                showProgressBar.postValue(false)

                //Версия до 41 модуля
                //interactor.getFilmsFromApi(1, object : ApiCallback {
                //override fun onSuccess(films: List<Film>) {
                //filmsListLiveData.postValue(films)
                //}

                //override fun onFailure() {
                //Executors.newSingleThreadExecutor().execute {
                //filmsListLiveData.postValue(interactor.getFilmsFromDB())
                //}
            }
        })
    }

    interface ApiCallback {
        fun onSuccess()
        //Версия до 41 модуля
        //fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}
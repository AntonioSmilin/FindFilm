package com.tonykuz.findfilm.domain

import com.tonykuz.findfilm.data.*
import com.tonykuz.findfilm.data.Entity.Film
import com.tonykuz.findfilm.data.Entity.TmdbResultsDto
import com.tonykuz.findfilm.data.MainRepository
import com.tonykuz.findfilm.data.TmdbApi
import com.tonykuz.findfilm.data.preferenes.PreferenceProvider
import com.tonykuz.findfilm.utils.Converter
import com.tonykuz.findfilm.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
            //При успехе мы вызываем метод, передаем onSuccess и в этот коллбэк список фильмов
            val list = Converter.convertApiListToDtoList(response.body()?.tmdbFilms)
            //Кладем фильмы в бд
            list.forEach {
                repo.putToDb(list)
            }
            callback.onSuccess(list)
        }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): List<Film> = repo.getAllFromDB()
}
package com.tonykuz.findfilm.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tonykuz.findfilm.data.ApiConstants
import com.tonykuz.findfilm.databinding.FilmItemBinding
import com.tonykuz.findfilm.domain.Film

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val filmBinding = FilmItemBinding.bind(itemView)

    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {


        //Устанавливаем заголовок
        filmBinding.title.text = film.title
        //Устанавливаем постер
        //Указываем контейнер, в котором будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(filmBinding.poster)
        //Устанавливаем описание
        filmBinding.description.text = film.description
        //Устанавливаем рэйтинг
        filmBinding.ratingDonut.setProgress((film.rating * 10).toInt())
    }
}
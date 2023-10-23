package com.tonykuz.findfilm

import android.os.Bundle
import com.tonykuz.findfilm.databinding.FragmentDetailsBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {
    private var detailBinding: FragmentDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        detailBinding?.detailsToolbar?.title = film.title
        //Устанавливаем картинку
        detailBinding?.detailsPoster?.setImageResource(film.poster)
        //Устанавливаем описание
        detailBinding?.detailsDescription?.text = film.description
    }
}
package com.tonykuz.findfilm.view.fragments

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonykuz.findfilm.databinding.FragmentHomeBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
//import com.tonykuz.findfilm.databinding.MergeHomeScreenContentBinding
//import java.util.Locale
import java.util.*
//import android.view.Gravity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import androidx.transition.Scene
//import androidx.transition.Slide
//import androidx.transition.TransitionManager
//import androidx.transition.TransitionSet
//import com.tonykuz.findfilm.*
import com.tonykuz.findfilm.R
import com.tonykuz.findfilm.domain.Film
import com.tonykuz.findfilm.utils.AnimationHelper
import com.tonykuz.findfilm.view.MainActivity
import com.tonykuz.findfilm.view.rv_adapters.FilmListRecyclerAdapter
import com.tonykuz.findfilm.view.rv_adapters.TopSpacingItemDecoration
import com.tonykuz.findfilm.viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    //private lateinit var binding2: MergeHomeScreenContentBinding

    private var filmsDataBase = listOf<Film>()
        //Используем backing field
        set(value) {
            //Если придет такое же значение, то мы выходим из метода
            if (field == value) return
            //Если пришло другое значение, то кладем его в переменную
            field = value
            //Обновляем RV адаптер
            filmsAdapter.addItems(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        //binding2 = MergeHomeScreenContentBinding.inflate(layoutInflater, binding.homeFragmentRoot, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(
            binding.homeFragmentRoot,
            requireActivity(),
            1
        )

        initSearchView()
        initPullToRefresh()
        //находим наш RV
        initRecycler()
        //Кладем нашу БД в RV
        viewModel.filmsListLiveData.observe(viewLifecycleOwner, Observer<List<Film>> {
            filmsDataBase = it
            filmsAdapter.addItems(it)
        })
    }
        private fun initPullToRefresh() {
            //Вешаем слушатель, чтобы вызвался pull to refresh
            binding.pullToRefresh.setOnRefreshListener {
                //Чистим адаптер(items нужно будет сделать паблик или создать для этого публичный метод)
                filmsAdapter.items.clear()
                //Делаем новый запрос фильмов на сервер
                viewModel.getFilms()
                //Убираем крутящееся колечко
                binding.pullToRefresh.isRefreshing = false
            }
        }

        private fun initSearchView() {
            binding.searchView.setOnClickListener {
                binding.searchView.isIconified = false
            }

            //Подключаем слушателя изменений введенного текста в поиска
            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                //Этот метод отрабатывает на каждое изменения текста
                override fun onQueryTextChange(newText: String): Boolean {
                    //Если ввод пуст то вставляем в адаптер всю БД
                    if (newText.isEmpty()) {
                        filmsAdapter.addItems(filmsDataBase)
                        return true
                    }
                    //Фильтруем список на поискк подходящих сочетаний
                    val result = filmsDataBase.filter {
                        //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                        it.title.toLowerCase(Locale.getDefault())
                            .contains(newText.toLowerCase(Locale.getDefault()))
                    }
                    //Добавляем в адаптер
                    filmsAdapter.addItems(result)
                    return true
                }
            })
        }
    private fun initRecycler() {
        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}

                //val scene = Scene(binding.homeFragmentRoot, binding2.root)
                // search view animation
                //val searchSlide = Slide(Gravity.TOP).addTarget(R.id.searchView)
                // RV animation
                //val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.mainRecycler)
                //val customTransition = TransitionSet().apply {
                //    duration = 500
                //    addTransition(recyclerSlide)
                //    addTransition(searchSlide)
                //}

                //TransitionManager.go(scene, customTransition)

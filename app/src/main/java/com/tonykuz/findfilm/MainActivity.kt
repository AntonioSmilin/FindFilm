package com.tonykuz.findfilm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tonykuz.findfilm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Буду смотреть", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборка", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }

    fun onClickToast1(view: View) {
        Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
    fun onClickToast2(view: View) {
        Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
    }
    fun onClickToast3(view: View) {
        Toast.makeText(this, "Буду смотреть", Toast.LENGTH_SHORT).show()
    }
    fun onClickToast4(view: View) {
        Toast.makeText(this, "Профиль", Toast.LENGTH_SHORT).show()
    }
    fun onClickToast5(view: View) {
        Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
    }

    }
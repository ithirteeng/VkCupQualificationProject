package com.example.vkcupqualificationproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vkcupqualificationproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val categoriesArray = arrayOf(
		"Юмор",
		"Еда",
		"Кино",
		"Рестораны",
		"Прогулки",
		"Политика",
		"Новости",
		"Автомобили",
		"Сериалы",
		"Рецепты",
		"Работа",
		"Отдых",
		"Спорт",
		"Кодинг",
		"Скейтбординг",
		"Доставание соседей",
		"Учеба",
		"Книги",
		"Приколы",
		"Электроника",
		"Цирк",
	)

	private val binding by lazy {
		ActivityMainBinding.inflate(this.layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)


	}
}
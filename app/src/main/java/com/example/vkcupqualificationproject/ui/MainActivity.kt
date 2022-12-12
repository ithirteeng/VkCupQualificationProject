package com.example.vkcupqualificationproject.ui

import android.os.Bundle
import android.view.ViewGroup
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
		setupFlexBox()

	}

	private fun setupFlexBox() {
		binding.flexBox.removeAllViews()
		for (category in categoriesArray) {
			val categoryView = CategoryCustomView(context = this)
			categoryView.setCategoryText(category)
			categoryView.onButtonClickListener()
			binding.flexBox.addView(categoryView)
			setCategoryMargin(categoryView)
		}
	}

	private fun setCategoryMargin(categoryView: CategoryCustomView) {
		val params = categoryView.layoutParams as ViewGroup.MarginLayoutParams
		params.marginEnd = 30
		params.topMargin = 30
	}
}
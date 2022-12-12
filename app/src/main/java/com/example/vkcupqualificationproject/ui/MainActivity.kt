package com.example.vkcupqualificationproject.ui

import android.os.Bundle
import android.util.Log
import android.view.View
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

	private val categoryViewsList = arrayListOf<CategoryCustomView>()

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
			categoryViewsList.add(categoryView)
			categoryView.setCategoryText(category)
			categoryView.setOnCategoryClickListener {
				changeContinueButtonVisibility()
				Log.d("SHIIIT", countSelectedCategories().toString())
			}
			binding.flexBox.addView(categoryView)
			setCategoryMargin(categoryView)
		}
	}

	private fun changeContinueButtonVisibility() {
		if (countSelectedCategories() == 0) {
			binding.continueButton.visibility = View.GONE
		} else {
			binding.continueButton.visibility = View.VISIBLE
		}
	}

	private fun setCategoryMargin(categoryView: CategoryCustomView) {
		val params = categoryView.layoutParams as ViewGroup.MarginLayoutParams
		params.marginEnd = 30
		params.topMargin = 30
	}

	private fun countSelectedCategories(): Int {
		var count = 0
		for (categoryView in categoryViewsList) {
			if (categoryView.checkIfCategorySelected()) {
				count++
			}
		}
		return count
	}
}
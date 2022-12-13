package com.example.vkcupqualificationproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.vkcupqualificationproject.R
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
		setAnimationForContinueButton()
	}

	private fun setupFlexBox() {
		binding.flexBox.removeAllViews()
		for (category in categoriesArray) {
			val categoryView = CategoryCustomView(context = this)
			categoryViewsList.add(categoryView)
			categoryView.setCategoryText(category)
			categoryView.setOnCategoryClickListener {
				changeContinueButtonVisibility()
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

	@SuppressLint("ClickableViewAccessibility")
	private fun setAnimationForContinueButton() {
		val scaleUpAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_up_button)
		val scaleDownAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_down_button)
		binding.continueButton.setOnTouchListener { button, motionEvent ->
			if (motionEvent.action == MotionEvent.ACTION_DOWN) {
				button.startAnimation(scaleUpAnimation)
			} else if (motionEvent.action == MotionEvent.ACTION_UP) {
				button.startAnimation(scaleDownAnimation)
			} else if (button.isPressed) {
				button.startAnimation(scaleDownAnimation)
			}
			true
		}
	}
}
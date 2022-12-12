package com.example.vkcupqualificationproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.TransitionDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.vkcupqualificationproject.R
import com.example.vkcupqualificationproject.databinding.CustomViewCategoryBinding

class CategoryCustomView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {

	private val categoryView: View = LayoutInflater.from(context).inflate(R.layout.custom_view_category, this)
	private val binding = CustomViewCategoryBinding.bind(categoryView)

	private var isCardSelected = false

	@SuppressLint("UseCompatLoadingForDrawables")
	private fun addAnimation() {
		val tickToAdd: AnimatedVectorDrawable = this.resources.getDrawable(R.drawable.avd_tick_to_add, context.theme) as AnimatedVectorDrawable
		val addToTick: AnimatedVectorDrawable = this.resources.getDrawable(R.drawable.avd_add_to_tick, context.theme) as AnimatedVectorDrawable
		val drawable: AnimatedVectorDrawable = if (isCardSelected) tickToAdd else addToTick
		binding.imageButton.setImageDrawable(drawable)
		drawable.start()
		isCardSelected = !isCardSelected
	}

	@SuppressLint("UseCompatLoadingForDrawables")
	private fun recolorCardView() {
		val orangeColor = this.resources.getDrawable(R.drawable.card_orange_background, context.theme)
		val grayColor = this.resources.getDrawable(R.drawable.card_gray_background, context.theme)

		var colorsArray = arrayOf(orangeColor, grayColor)
		if (isCardSelected) {
			colorsArray = arrayOf(grayColor, orangeColor)
		}

		val transition = TransitionDrawable(colorsArray)
		binding.mainLayout.background = transition
		transition.startTransition(resources.getInteger(R.integer.category_animation_duration))
	}

	fun setOnCategoryClickListener(onCategoryClick: () -> Unit) {
		binding.mainLayout.setOnClickListener {
			addAnimation()
			recolorCardView()
			onCategoryClick()
		}
	}

	fun setCategoryText(category: String) {
		binding.textView.text = category
	}

	fun checkIfCategorySelected(): Boolean {
		return isCardSelected
	}


}
package com.example.vkcupqualificationproject

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
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
		transition.startTransition(450)
	}

	fun onButtonClickListener() {
		binding.mainLayout.setOnClickListener {
			addAnimation()
			recolorCardView()
		}
	}


}
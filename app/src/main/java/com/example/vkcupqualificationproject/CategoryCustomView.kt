package com.example.vkcupqualificationproject

import android.content.Context
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




}
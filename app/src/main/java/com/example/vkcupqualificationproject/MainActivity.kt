package com.example.vkcupqualificationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vkcupqualificationproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val binding by lazy {
		ActivityMainBinding.inflate(this.layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)


		binding.item.onButtonClickListener()
	}
}
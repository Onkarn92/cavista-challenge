package com.onkarnene.cavista.challenge.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onkarnene.cavista.challenge.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivitySearchBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySearchBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}
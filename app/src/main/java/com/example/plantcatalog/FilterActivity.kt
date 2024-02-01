package com.example.plantcatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.plantcatalog.databinding.FilterSectionBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: FilterSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilterSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
    }
}

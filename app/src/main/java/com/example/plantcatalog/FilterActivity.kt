package com.example.plantcatalog

import android.app.Activity
import android.content.Intent
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


        binding.kaktusFilter.setOnClickListener {
            sendFilterResult("kaktus")
        }

        binding.palmFilter.setOnClickListener {
            sendFilterResult("palm")
        }

        binding.liliaFilter.setOnClickListener {
            sendFilterResult("lilia")
        }

        binding.roseFilter.setOnClickListener {
            sendFilterResult("rose")
        }

        binding.tulipFilter.setOnClickListener {
            sendFilterResult("tulip")
        }
    }

    private fun sendFilterResult(filter: String) {
        val resultIntent = Intent()
        resultIntent.putExtra("filter", filter)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}

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
        val plants = resources.getStringArray(R.array.plants_array)
        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }


        binding.kaktusFilter.setOnClickListener {
            sendFilterResult(plants[0])
        }

        binding.palmFilter.setOnClickListener {
            sendFilterResult(plants[1])
        }

        binding.liliaFilter.setOnClickListener {
            sendFilterResult(plants[2])
        }

        binding.roseFilter.setOnClickListener {
            sendFilterResult(plants[3])
        }

        binding.tulipFilter.setOnClickListener {
            sendFilterResult(plants[4])
        }
    }

    private fun sendFilterResult(filter: String) {
        val resultIntent = Intent()
        resultIntent.putExtra("plantType", filter)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}

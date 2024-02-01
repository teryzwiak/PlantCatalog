package com.example.plantcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AboutUsSectionBinding


class AboutActivity : AppCompatActivity() {

    private lateinit var binding: AboutUsSectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AboutUsSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
    }

}
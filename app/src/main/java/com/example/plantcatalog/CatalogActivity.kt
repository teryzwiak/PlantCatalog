package com.example.plantcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.CatalogSectionBinding
import com.example.plantcatalog.databinding.OptionSectionBinding


class CatalogActivity : AppCompatActivity() {

    private lateinit var binding: CatalogSectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CatalogSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
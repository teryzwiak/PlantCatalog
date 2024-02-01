package com.example.plantcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AddItemSectionBinding
import com.example.plantcatalog.databinding.OptionSectionBinding


class AdditemActivity : AppCompatActivity() {

    private lateinit var binding: AddItemSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AddItemSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }
    }

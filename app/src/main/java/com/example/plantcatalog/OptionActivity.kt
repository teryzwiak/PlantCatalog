package com.example.plantcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.OptionSectionBinding


class OptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionSectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OptionSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutUs.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
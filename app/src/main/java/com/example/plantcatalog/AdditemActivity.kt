package com.example.plantcatalog

import DbHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AddItemSectionBinding
import com.example.plantcatalog.databinding.OptionSectionBinding


class MyAdapter {

}

class AdditemActivity : AppCompatActivity() {

    private lateinit var binding: AddItemSectionBinding
    private val dataList = mutableListOf<MyModel>()
    private lateinit var adapter: MyAdapter
    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AddItemSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }

        dbHelper = DbHelper(this)


        }
    }





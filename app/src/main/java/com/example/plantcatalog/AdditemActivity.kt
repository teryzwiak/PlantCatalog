package com.example.plantcatalog

import DbHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AddItemSectionBinding
import com.example.plantcatalog.databinding.OptionSectionBinding
import MyAdapter
import android.widget.Toast


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
        binding.buttonSave.setOnClickListener {
            saveDataToDB()
            showToast("Roslina dodana")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun saveDataToDB(){
        val name = binding.editTextPlantName.text.toString()
        val country = binding.editTextCountry.text.toString()
        val type = binding.spinnerPlantType.toString()
        val description = binding.editTextDescription.text.toString()
        val url = "test"

        val myModel = MyModel(0, name, country, type, description, url)
        val insertedId = dbHelper.insertData(myModel)
    }
    }





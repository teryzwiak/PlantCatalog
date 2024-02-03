package com.example.plantcatalog

import DbHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AddItemSectionBinding
import android.view.View
import android.widget.AdapterView
import android.widget.Toast


class AdditemActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: AddItemSectionBinding
    private lateinit var dbHelper: DbHelper

    private var selectedItemType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AddItemSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
        binding.spinnerPlantType.onItemSelectedListener = this

        dbHelper = DbHelper(this)
        binding.buttonSave.setOnClickListener {
            saveDataToDB()

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun saveDataToDB() {
        val name = binding.editTextPlantName.text.toString()
        val country = binding.editTextCountry.text.toString()
        val type = selectedItemType
        val description = binding.editTextDescription.text.toString()
        val url = "test"

        if (name.isBlank()) {
            showToast("Nazwa rośliny jest wymagana!")
            return
        }

        val myModel = MyModel(0, name, country, type, description, url)
        dbHelper.addData(myModel)
        showToast("Roslina dodana")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedItemType = parent?.getItemAtPosition(position) as String
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}





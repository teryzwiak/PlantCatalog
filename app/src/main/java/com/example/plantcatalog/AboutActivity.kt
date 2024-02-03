package com.example.plantcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantcatalog.databinding.AboutUsSectionBinding
import DbHelper
import MyAdapter



class AboutActivity : AppCompatActivity() {

    private lateinit var binding: AboutUsSectionBinding
    private lateinit var dbHelper: DbHelper
    private lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AboutUsSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DbHelper(this)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
        binding.buttonClearData.setOnClickListener {
            dbHelper.clearAllData()
            updateAdapterData()
        }
    }
    private fun updateAdapterData() {
        // Pobierz dane z bazy SQLite i zaktualizuj adapter
        adapter.updateData(dbHelper.getAllData())
        adapter.notifyDataSetChanged()
    }
}
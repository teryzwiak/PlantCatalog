package com.example.plantcatalog

import DbHandler
import DbHelper
import MyAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantcatalog.databinding.CatalogSectionBinding
import com.example.plantcatalog.databinding.OptionSectionBinding

private var dbHandler: DbHandler? = null


class CatalogActivity : AppCompatActivity() {

    private lateinit var binding: CatalogSectionBinding
    private lateinit var dbHelper: DbHelper
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CatalogSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()

        }

        dbHelper = DbHelper(this)

        // Inicjalizacja adaptera
        adapter = MyAdapter(dbHelper.getAllData())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Dodaj przykładowe dane do bazy SQLite
        addDataToSQLite()

        // Pobierz dane z bazy SQLite i zaktualizuj adapter
        updateAdapterData()

        var allData = dbHandler?.getAllData()
        Log.d(allData.toString(), "Mess: $allData")
    }
    override fun onResume() {
        super.onResume()


        binding.buttonFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun addDataToSQLite() {
        dbHelper.addData(MyModel(1, "Tulipan", "Holandia", "Tulipan", "Description ", "URL1"))
        dbHelper.addData(MyModel(2, "Róża", "Polska", "Róża", "Description 2", "URL2"))
        dbHelper.addData(MyModel(3, "Kaktus", "Etopia", "Kaktus", "Description 3", "URL3"))
    }

    private fun updateAdapterData() {
        // Pobierz dane z bazy SQLite i zaktualizuj adapter
        adapter.updateData(dbHelper.getAllData())
        adapter.notifyDataSetChanged()
    }

    }

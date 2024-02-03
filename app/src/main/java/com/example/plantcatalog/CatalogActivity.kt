package com.example.plantcatalog

import DbHelper
import MyAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantcatalog.databinding.CatalogSectionBinding

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
    }

    override fun onResume() {
        super.onResume()

        binding.buttonFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivityForResult(intent, FILTER_REQUEST_CODE)
        }
    }

    private fun addDataToSQLite() {
        dbHelper.addData(MyModel(1, "Tulipan", "Holandia", "@+id/tulip_filter", "Description ", "URL1"))
        dbHelper.addData(MyModel(2, "Róża", "Polska", "Róża", "Description 2", "URL2"))
        dbHelper.addData(MyModel(3, "Kaktus", "Etopia", "Kaktus", "Description 3", "URL3"))
    }

    private fun updateAdapterData() {
        // Pobierz dane z bazy SQLite i zaktualizuj adapter
        adapter.updateData(dbHelper.getAllData())
        adapter.notifyDataSetChanged()
    }

    companion object {
        const val FILTER_REQUEST_CODE = 100
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FILTER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val filterId = data?.getIntExtra("filterId", -1)
            filterId?.let {
                // Tutaj przekazujemy id przycisku do zastosowania filtra
                val filteredArticles = dbHelper.getAllData().filter { article ->
                    // Przekonwertuj ID przycisku na typ Long
                    val buttonIdLong = filterId.toLong()
                    // Porównaj ID przycisku z ID artykułów
                    article.id == buttonIdLong
                }
                adapter.updateData(filteredArticles)
                adapter.notifyDataSetChanged()
            }
        }
    }
}

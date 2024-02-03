// DbHandler.kt
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.plantcatalog.MyModel

class DbHandler(context: Context) {

    private val dbHelper = DbHelper(context)

    fun addData(myModel: MyModel) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", myModel.name)
        }
        db.insert("MyTable", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllData(): List<MyModel> {
        val dataList = mutableListOf<MyModel>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM MyTable", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val country = cursor.getString(cursor.getColumnIndex("country"))
                val type = cursor.getString(cursor.getColumnIndex("type"))
                val description = cursor.getString(cursor.getColumnIndex("description"))
                val url = cursor.getString(cursor.getColumnIndex("url"))
                val myModel = MyModel(id, name, country, type, description, url)
                dataList.add(myModel)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return dataList
    }
}

// DbHelper.kt
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.plantcatalog.MyModel

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "PlantCatalog"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Catalog"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_COUNTRY = "country"
        const val COLUMN_TYPE = "type"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_URL = "url"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, $COLUMN_COUNTRY TEXT, $COLUMN_TYPE TEXT, " +
                "$COLUMN_DESCRIPTION TEXT, $COLUMN_URL TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS MyTable")
        onCreate(db)
    }

    fun addData(myModel: MyModel) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, myModel.name)
            put(COLUMN_COUNTRY, myModel.country)
            put(COLUMN_TYPE, myModel.type)
            put(COLUMN_DESCRIPTION, myModel.description)
            put(COLUMN_URL, myModel.url)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllData(): List<MyModel> {
        val dataList = mutableListOf<MyModel>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val country = cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY))
                val type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE))
                val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                val url = cursor.getString(cursor.getColumnIndex(COLUMN_URL))

                val myModel = MyModel(id, name, country, type, description, url)
                dataList.add(myModel)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return dataList
    }

    fun clearAllData() {
        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
        db.close()
    }

    fun insertData(myModel: MyModel): Long {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_NAME, myModel.name)
        values.put(COLUMN_COUNTRY, myModel.country)
        values.put(COLUMN_TYPE, myModel.type)
        values.put(COLUMN_DESCRIPTION, myModel.description)
        values.put(COLUMN_URL, myModel.url)

        val id = db.insert(TABLE_NAME, null, values)
        db.close()

        return id
    }
}

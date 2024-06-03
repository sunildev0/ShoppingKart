package com.example.testappsunil.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testappsunil.utils.Converters

@Database(
    entities = [ProductsData::class], version = 1
)
@TypeConverters(Converters::class)
abstract class ProductsDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "my_db"
    }

    abstract fun productsDao(): ProductsDao
}
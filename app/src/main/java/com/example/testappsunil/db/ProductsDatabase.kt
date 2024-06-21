package com.example.testappsunil.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [ProductsData::class], version = 1
)

abstract class ProductsDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "my_db"
    }

    abstract fun productsDao(): ProductsDao
}
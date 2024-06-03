package com.example.testappsunil.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsData(data: List<ProductsData>)

    @Query("SELECT * FROM ProductsData")
    suspend fun getProductsData(): List<ProductsData>
}
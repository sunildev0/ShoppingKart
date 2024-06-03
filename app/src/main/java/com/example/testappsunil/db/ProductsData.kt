package com.example.testappsunil.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ProductsData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("pages") val pages: Int? = null,
    @SerializedName("avg") val avg: Double? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("square") val square: String? = null,
    @SerializedName("wide") val wide: String? = null
)
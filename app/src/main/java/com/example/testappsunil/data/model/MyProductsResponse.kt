package com.example.testappsunil.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MyProductsResponse(
    @SerializedName("image") val image: String? = null,
    @SerializedName("price") val price: Double? = null,
    @SerializedName("discounted_price") val discountedPrice: Double = 0.0,
    @SerializedName("discount_percentage") val discountPercentage: Int = 0,
    @SerializedName("rating") val rating: Rating? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("category") val category: String? = null
) {
    @Serializable
    data class Rating(
        @SerializedName("rate") val rate: Double? = null,
        @SerializedName("count") val count: Int? = null
    )
}



package com.example.testappsunil.data.model

import com.google.gson.annotations.SerializedName


//data class MyProductsResponse(
//    @SerializedName("Response") val response: List<ProductDetail?>? = null
//) {
    data class MyProductsResponse(
        @SerializedName("image") val image: String? = null,
        @SerializedName("price") val price: Any? = null,
        @SerializedName("rating") val rating: Rating? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("category") val category: String? = null
    ) {
        data class Rating(
            @SerializedName("rate") val rate: Any? = null,
            @SerializedName("count") val count: Int? = null
        )
    }
//}

//class Example {
//    @SerializedName("id")
//    @Expose
//    var id: Int? = null
//
//    @SerializedName("title")
//    @Expose
//    var title: String? = null
//
//    @SerializedName("price")
//    @Expose
//    var price: Double? = null
//
//    @SerializedName("description")
//    @Expose
//    var description: String? = null
//
//    @SerializedName("category")
//    @Expose
//    var category: String? = null
//
//    @SerializedName("image")
//    @Expose
//    var image: String? = null
//
//    @SerializedName("rating")
//    @Expose
//    var rating: Rating? = null
//}
//
//class Rating {
//    @SerializedName("rate")
//    @Expose
//    var rate: Double? = null
//
//    @SerializedName("count")
//    @Expose
//    var count: Int? = null
//}




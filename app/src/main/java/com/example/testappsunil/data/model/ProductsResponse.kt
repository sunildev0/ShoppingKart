package com.example.testappsunil.data.model

import com.example.testappsunil.db.ProductsData
import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products") val products: Products? = null
) {
    data class Products(
        @SerializedName("DT") val dT: ProductsData? = null,
        @SerializedName("MP") val mP: ProductsData? = null,
        @SerializedName("WL") val wL: ProductsData? = null,
        @SerializedName("MR") val mR: ProductsData? = null,
        @SerializedName("PCOL") val pCOL: ProductsData? = null,
        @SerializedName("GM") val gM: ProductsData? = null,
        @SerializedName("PPOL") val pPOL: ProductsData? = null,
        @SerializedName("LI") val lI: ProductsData? = null,
        @SerializedName("CP") val cP: ProductsData? = null,
        @SerializedName("YG") val yG: ProductsData? = null,
        @SerializedName("BP") val bP: ProductsData? = null,
        @SerializedName("ED") val eD: ProductsData? = null
    ) {
        data class ProductDetails(
            @SerializedName("vedic") val vedic: String? = null,
            @SerializedName("imagePath") val imagePath: ImagePath? = null,
            @SerializedName("availableLanguages") val availableLanguages: List<String?>? = null,
            @SerializedName("remedies") val remedies: String? = null,
            @SerializedName("description") val description: String? = null,
            @SerializedName("pagesintext") val pagesintext: String? = null,
            @SerializedName("discount") val discount: Int? = null,
            @SerializedName("report_type") val reportType: String? = null,
            @SerializedName("sampleReports") val sampleReports: SampleReports? = null,
            @SerializedName("couponDiscount") val couponDiscount: Int? = null,
            @SerializedName("pages") val pages: Int? = null,
            @SerializedName("avg") val avg: Double? = null,
            @SerializedName("price") val price: Int? = null,
            @SerializedName("soldcount") val soldcount: String? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("authentic") val authentic: String? = null,
            @SerializedName("appDiscount") val appDiscount: Int? = null
        ) {
            data class ImagePath(
                @SerializedName("square") val square: String? = null,
                @SerializedName("wide") val wide: String? = null
            )

            data class SampleReports(
                @SerializedName("ENG") val english: String? = null,
                @SerializedName("HIN") val hindi: String? = null
            )
        }
    }
}

//fun ProductsResponse.Products.ProductsData.toKeyProductsData() = ProductsData(
//    name = name,
//    description = description,
//    price = price,
//    avg = avg,
//    pages = pages,
//    square = imagePath?.square,
//    wide = imagePath?.wide
//)

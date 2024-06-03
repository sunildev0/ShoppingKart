package com.example.testappsunil.data.datasource

import com.example.testappsunil.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsDataSource {

    @GET("test/products.php")
    suspend fun getProductsData(): Response<ProductsResponse>

}
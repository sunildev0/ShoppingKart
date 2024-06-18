package com.example.testappsunil.data.datasource

import com.example.testappsunil.data.model.MyProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsDataSource {

    @GET("products")
    suspend fun getProductsData(): Response<List<MyProductsResponse>>

}
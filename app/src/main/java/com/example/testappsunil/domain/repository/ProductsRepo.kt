package com.example.testappsunil.domain.repository

import com.example.testappsunil.data.model.MyProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRepo {

    suspend fun getProducts(): Flow<Response<List<MyProductsResponse>>>
}
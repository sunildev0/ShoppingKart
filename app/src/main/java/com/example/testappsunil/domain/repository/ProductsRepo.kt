package com.example.testappsunil.domain.repository

import com.example.testappsunil.data.model.ProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRepo {

    suspend fun getProducts(): Flow<Response<ProductsResponse>>
}
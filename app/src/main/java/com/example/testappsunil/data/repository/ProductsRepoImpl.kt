package com.example.testappsunil.data.repository

import com.example.testappsunil.data.datasource.ProductsDataSource
import com.example.testappsunil.domain.repository.ProductsRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val dataSource: ProductsDataSource) :
    ProductsRepo {

    override suspend fun getProducts() = flow {
        val response = dataSource.getProductsData()
        emit(response)
    }
}
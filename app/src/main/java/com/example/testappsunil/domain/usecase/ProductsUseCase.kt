package com.example.testappsunil.domain.usecase

import com.example.testappsunil.domain.repository.ProductsRepo
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val repo: ProductsRepo) {

    suspend fun getProductsData() = repo.getProducts()

}
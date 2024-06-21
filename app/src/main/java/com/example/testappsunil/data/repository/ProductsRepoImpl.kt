package com.example.testappsunil.data.repository

import android.content.Context
import android.util.Log
import com.example.testappsunil.data.datasource.ProductsDataSource
import com.example.testappsunil.data.model.MyProductsResponse
import com.example.testappsunil.domain.repository.ProductsRepo
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import retrofit2.Response
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val dataSource: ProductsDataSource,
    @ApplicationContext private val context: Context
) :
    ProductsRepo {

    override suspend fun getProducts(): Flow<Response<List<MyProductsResponse>>> {
        return flow {
            val response = dataSource.getProductsData()
            if (response.isSuccessful) {
                emit(Response.success(response.body()))
            } else {
                if (response.code().toString().startsWith("5")) {
                    val mockResponse = getMockResponse()
                    emit(Response.success(mockResponse))
                }
            }
        }.catch {
            val responseMock = getMockResponse()
            emit(Response.success(responseMock))
        }
    }

    private fun getMockResponse(): List<MyProductsResponse> {
        val assetManager = context.assets
        val inputStream = assetManager.open("mock.json")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        return Json.decodeFromString(fileContent)
    }
}
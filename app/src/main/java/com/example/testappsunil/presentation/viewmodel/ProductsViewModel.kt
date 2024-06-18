package com.example.testappsunil.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappsunil.data.model.MyProductsResponse
import com.example.testappsunil.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val useCase: ProductsUseCase) : ViewModel() {

    private val _getProductsResponse = MutableSharedFlow<Response<List<MyProductsResponse>>>()
    val getProductsResponse = _getProductsResponse.asSharedFlow()

    fun getProductsDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getProductsData().collect {
                withContext(Dispatchers.Main.immediate) {
                    if (it.isSuccessful) {
                        _getProductsResponse.emit(it)
                    }
                }
            }
        }
    }


}
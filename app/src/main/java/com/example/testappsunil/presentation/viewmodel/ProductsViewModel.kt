package com.example.testappsunil.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappsunil.data.model.MyProductsResponse
import com.example.testappsunil.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<MyProductsResponse>) : UiState()
    data class Error(val message: String) : UiState()
}

@HiltViewModel
class ProductsViewModel @Inject constructor(private val useCase: ProductsUseCase) : ViewModel() {

    private val _getProductsResponse = MutableStateFlow<UiState>(UiState.Loading)
    val getProductsResponse: StateFlow<UiState> = _getProductsResponse

    init {
        getProductsDetails()
    }

    private fun getProductsDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _getProductsResponse.value = UiState.Loading
            try {
                useCase.getProductsData().collect {
                    if (it.isSuccessful) {
                        val products = it.body() ?: emptyList()
                        _getProductsResponse.value = UiState.Success(products)
                    } else {
                        _getProductsResponse.value = UiState.Error("Error!")
                    }
                }
            } catch (e: Exception) {
                _getProductsResponse.value = UiState.Error("Exception ${e.message}!")
            }
        }
    }
}
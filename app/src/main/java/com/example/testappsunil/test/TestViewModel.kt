package com.example.testappsunil.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    private var _testLiveData: MutableLiveData<String> = MutableLiveData()
    val testLiveData: LiveData<String> = _testLiveData

//    val stateFlow: MutableSharedFlow<Int> = MutableSharedFlow(
//        replay = 3
//    )

//    init {
//        testing()
//    }

//    fun testing() {
//        viewModelScope.launch {
//            repeat(10) {
//                delay(1000)
//                stateFlow.emit(it)
//            }
//        }
//    }

    fun setData(value: String) {
        _testLiveData.postValue(value)
        Log.d("TAGdata", "setData: viewModel:  ${value}")
    }

    val str = "Testingdata"

}
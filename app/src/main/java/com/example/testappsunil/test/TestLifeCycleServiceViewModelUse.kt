package com.example.testappsunil.test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.concurrent.thread

class TestLifeCycleServiceViewModelUse : Service(),
    ViewModelStoreOwner {

    private lateinit var viewModel: TestViewModel
    override val viewModelStore = ViewModelStore()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            TestViewModel::class.java)

        thread {
            val data = fetchDataFromNetwork()
            viewModel.setData(data)
//            stopSelf()
            Log.d("TAGdata", "service: $data = ${viewModel.str}")

        }
        return START_STICKY
    }

    private fun fetchDataFromNetwork(): String {
        Thread.sleep(2000) // Simulate delay
        return "Hello from background thread in Service!"
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}
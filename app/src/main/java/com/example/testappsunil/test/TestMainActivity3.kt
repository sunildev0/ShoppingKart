package com.example.testappsunil.test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testappsunil.R

class TestMainActivity3 : AppCompatActivity() {

    private lateinit var textView: TextView
//    private lateinit var broadcastReceiver: BroadcastReceiver

    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main3)

        textView = findViewById(R.id.tv_hello)

        val intent = Intent(this, TestLifeCycleServiceViewModelUse::class.java)
        startService(intent)

//        broadcastReceiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//                val data = intent?.getStringExtra("data_for_ui")
//                textView.text = data
//                Log.d("TAGData", "onReceive: $data = ${textView.text}")
//            }
//        }

//        registerReceiver(broadcastReceiver, IntentFilter("UI_DATA"))

        testViewModel.testLiveData.observe(this) {
            Log.d("TAGdata", "onCreate activity: $it")
            textView.text = it
        }

//        val intent = Intent(this, TestServiceBroadcastReceiverUse::class.java)
//        startService(intent)


    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(broadcastReceiver)
    }
}
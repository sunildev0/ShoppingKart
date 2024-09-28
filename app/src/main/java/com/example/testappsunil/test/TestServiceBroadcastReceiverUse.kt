package com.example.testappsunil.test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.concurrent.thread

class TestServiceBroadcastReceiverUse: Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        thread {
            val data = getData()
            val broadCastIntent = Intent("UI_DATA")
            broadCastIntent.putExtra("data_for_ui", data)
            sendBroadcast(broadCastIntent)
        }

        return START_STICKY

    }

    private fun getData(): String {
        Thread.sleep(10000)
        return "Hello from server response!"
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
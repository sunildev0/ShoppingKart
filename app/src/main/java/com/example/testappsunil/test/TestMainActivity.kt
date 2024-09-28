package com.example.testappsunil.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.testappsunil.R

class TestMainActivity : AppCompatActivity() {

    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main)



//        lifecycleScope.launch {
//            viewModel.stateFlow.collectLatest {
////                Log.d("TAGGGG", "onCreate 1: $it")
//            }
//        }

//        lifecycleScope.launch {
//            delay(1000)
//            viewModel.stateFlow.collectLatest {
//                Log.d("TAGGGG", "onCreate 2: $it")
//            }
//        }



        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, TestMainActivity2::class.java))
        }

        findViewById<Button>(R.id.button_dialog).setOnClickListener {
            showAlertDialog()
        }

        Toast.makeText(this, "1 onCreate!", Toast.LENGTH_SHORT).show()
//        finish()
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is a simple alert dialog.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "1 onStart!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "1 onResume!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "1 onPause!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "1 onStop!", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "1 onRestart!", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "1 onDestroy!", Toast.LENGTH_SHORT).show()
    }
}
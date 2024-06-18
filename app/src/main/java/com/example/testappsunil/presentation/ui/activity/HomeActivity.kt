package com.example.testappsunil.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.testappsunil.R
import com.example.testappsunil.databinding.LayoutHomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: LayoutHomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.layout_home_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment)
        navHostFragment?.findNavController()?.apply {
            navigateUp()
            navigate(R.id.productDetailsFragment)
        }
    }
}
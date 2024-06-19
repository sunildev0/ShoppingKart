package com.example.testappsunil.presentation.ui.composables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testappsunil.databinding.FragmentProductDescriptionBinding

class ProductDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentProductDescriptionBinding
    private lateinit var callback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDescriptionBinding.inflate(inflater)

        arguments?.apply {
            binding.tvProductName.text = getString(NAME)
            binding.tvProductDescription.text = getString(DESCRIPTION)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root)
                    .navigateUp()
            }
        }
        clickListeners()
    }

    private fun clickListeners() {
        binding.ivBack.setOnClickListener {
            callback.handleOnBackPressed()
        }
    }
}
package com.example.testappsunil.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.testappsunil.utils.OnProductItemClickListener
import com.example.testappsunil.R
import com.example.testappsunil.data.model.ProductsResponse
import com.example.testappsunil.databinding.LayoutProductDetailsFragmentBinding
import com.example.testappsunil.db.ProductsData
import com.example.testappsunil.presentation.adapter.ProductsListAdapter
import com.example.testappsunil.presentation.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val NAME = "name"
const val DESCRIPTION = "description"

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var binding: LayoutProductDetailsFragmentBinding
    private val productsViewModel: ProductsViewModel by viewModels()
    private lateinit var callback: OnBackPressedCallback


    private val adapter: ProductsListAdapter by lazy {
        ProductsListAdapter(object : OnProductItemClickListener {
            override fun onClick(item: ProductsData) {
                val bundle = Bundle()
                bundle.putString(NAME, item.name)
                bundle.putString(DESCRIPTION, item.description)
                // Parcelize the data class to pass it.
                Navigation.findNavController(binding.root)
                    .navigate(R.id.productDescriptionFragment, bundle)
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LayoutProductDetailsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        clickListeners()
        dataObservers()
    }

    private fun clickListeners() {
        binding.ivBack.setOnClickListener {
            callback.handleOnBackPressed()
        }
    }

    private fun dataObservers() {
        productsViewModel.getProductsDetails()
        lifecycleScope.launch(Dispatchers.IO) {
            productsViewModel.getProductsResponse.collect {

                val list = it.body()?.products?.let { it1 -> convertUIData(it1) }

                withContext(Dispatchers.Main) {
                    binding.progressBar.isVisible = false
                    binding.rvProducts.adapter = adapter
                    list?.let { it1 -> adapter.setData(it1) }
                }



            }
        }
    }

    private fun convertUIData(products: ProductsResponse.Products): MutableList<ProductsData> {
        val mainList = emptyList<ProductsData>().toMutableList()
        products.yG?.let { mainList.add(it) }
        products.bP?.let { mainList.add(it) }
        products.cP?.let { mainList.add(it) }
        products.pCOL?.let { mainList.add(it) }
        products.pPOL?.let { mainList.add(it) }
        products.gM?.let { mainList.add(it) }
        products.dT?.let { mainList.add(it) }
        products.eD?.let { mainList.add(it) }
        products.lI?.let { mainList.add(it) }
        products.mP?.let { mainList.add(it) }
        products.mR?.let { mainList.add(it) }
        products.wL?.let { mainList.add(it) }
        return mainList
    }

}
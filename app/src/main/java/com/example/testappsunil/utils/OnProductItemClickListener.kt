package com.example.testappsunil.utils

import com.example.testappsunil.data.model.MyProductsResponse

interface OnProductItemClickListener {

    fun onClick(item: MyProductsResponse);

}
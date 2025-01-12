package com.github.kuj0j0taro123.myapplication

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFetcher {

    fun search(term : String) : List<Product>? {
        var products : List<Product>? = null
        // Fetch products
        RetrofitInstance.api.searchProducts(term).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {

                    products= response.body()?.products

                    products?.forEach { product ->
                        Log.d("MainActivity", "Product: ${product.title}")
                        Log.d("MainActivity", "Product description: ${product.description}")
                        Log.d("MainActivity", "Product Thumbnail: ${product.thumbnail}")
                    }
                } else {
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to fetch data", t)
            }
        })
        return products
    }
}
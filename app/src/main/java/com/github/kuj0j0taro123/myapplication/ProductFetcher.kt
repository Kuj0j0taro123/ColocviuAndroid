package com.github.kuj0j0taro123.myapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ProductFetcher {

    suspend fun search(term: String): List<Product>? {
        return try {
            // Switch to IO dispatcher to perform the network call
            val response = withContext(Dispatchers.IO) {
                RetrofitInstance.api.searchProducts(term)
            }

            // If the response is successful, return the products
            response.products
        } catch (e: Exception) {
            // Handle any errors such as network issues
            e.printStackTrace()
            null
        }
    }

}
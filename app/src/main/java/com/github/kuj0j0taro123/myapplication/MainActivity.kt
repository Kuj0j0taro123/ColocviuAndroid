package com.github.kuj0j0taro123.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch phones
        RetrofitInstance.api.searchPhones().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    // Log the product titles
                    response.body()?.products?.forEach { product ->
                        Log.d("MainActivity", "Product: ${product.title}")
                        Log.d("MainActivity", "Product description: ${product.description}")
                    }
                } else {
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to fetch data", t)
            }
        })
    }
}

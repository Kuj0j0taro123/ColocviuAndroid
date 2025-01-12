package com.github.kuj0j0taro123.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products/search")
    fun searchProducts(@Query("q") query: String): Call<ProductResponse>
}

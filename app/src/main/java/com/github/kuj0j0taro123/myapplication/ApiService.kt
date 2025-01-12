package com.github.kuj0j0taro123.myapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products/search")
    suspend fun searchProducts(@Query("q") query: String): ProductResponse
}

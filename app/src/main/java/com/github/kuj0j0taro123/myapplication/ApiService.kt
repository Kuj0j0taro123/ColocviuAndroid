package com.github.kuj0j0taro123.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products/search?q=apple")
    fun searchPhones(): Call<ProductResponse>
}

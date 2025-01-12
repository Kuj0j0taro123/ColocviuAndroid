package com.github.kuj0j0taro123.myapplication

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String
)

data class ProductResponse(
    val products: List<Product>
)

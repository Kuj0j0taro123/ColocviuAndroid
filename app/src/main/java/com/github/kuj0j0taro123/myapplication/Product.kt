package com.github.kuj0j0taro123.myapplication

data class Product(
    val id: Int,
    val title: String
)

data class ProductResponse(
    val products: List<Product>
)

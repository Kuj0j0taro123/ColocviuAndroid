package com.github.kuj0j0taro123.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String
) : Parcelable

@Parcelize
data class ProductResponse(
    val products: List<Product>
) : Parcelable

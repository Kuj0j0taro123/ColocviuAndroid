package com.github.kuj0j0taro123.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView


class ProductListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        val products = ProductListFragmentArgs.fromBundle(this.requireArguments()).ProductsArgument
        Log.d("ProductListFragment", products.toString())

        val productListLayout = view.findViewById<LinearLayout>(R.id.product_list)

        products?.forEach { product ->
//            Log.d("MainActivity", "Product: ${product.title}")
//            Log.d("MainActivity", "Product description: ${product.description}")
//            Log.d("MainActivity", "Product Thumbnail: ${product.thumbnail}")
            val textView = TextView(context).apply{
                text = product.title
                textSize = 18f
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            productListLayout.addView(textView)
        }

        return view
    }

}
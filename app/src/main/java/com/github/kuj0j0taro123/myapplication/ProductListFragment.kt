package com.github.kuj0j0taro123.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide


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
            val imageView = ImageView(context).apply{

                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }

            Glide.with(requireContext()).load(product.thumbnail).into(imageView)

            imageView.setOnClickListener{
                val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(product)
                view.findNavController().navigate(action)
            }

            productListLayout.addView(imageView)
        }

        return view
    }

}
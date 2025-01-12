package com.github.kuj0j0taro123.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import kotlinx.coroutines.runBlocking


class HomeFragment : Fragment() {
    val productFetcher : ProductFetcher = ProductFetcher()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // wtf is this ide doing, does not suggest search_button
        val searchButton = view.findViewById<Button>(R.id.search_button)
        val searchBox = view.findViewById<EditText>(R.id.search_box)

        searchButton.setOnClickListener{
            val query : String = searchBox.getText().toString()
            runBlocking{
                val products = productFetcher.search(query)
                Log.d("HomeFragment", products.toString())

                // i think you need that Safe Args plugin for this Directions class
                val action = HomeFragmentDirections.actionHomeFragmentToProductListFragment(products?.toTypedArray())
                view.findNavController().navigate(action)
            }
        }

        return view
    }

}
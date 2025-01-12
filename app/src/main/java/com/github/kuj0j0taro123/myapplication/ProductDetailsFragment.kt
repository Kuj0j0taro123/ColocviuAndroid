package com.github.kuj0j0taro123.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)

        val titleTextView = view.findViewById<TextView>(R.id.product_title_text_view)
        val detailsTextView = view.findViewById<TextView>(R.id.product_details_text_view)
        val detailsImageView = view.findViewById<ImageView>(R.id.product_details_image_view)
        val backButton = view.findViewById<Button>(R.id.product_details_back_button)

        val product = ProductDetailsFragmentArgs.fromBundle(this.requireArguments()).ProductArgument

//        // load image
//        Glide.with(requireContext()).load(product?.thumbnail).into(detailsImageView) // causes a crash for some reason
//        // load prod text
        titleTextView.text = product?.title
        detailsTextView.text = product?.description

        backButton.setOnClickListener{
            // i don't have a list to pass to the product list fragment lol
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        return view
    }
}
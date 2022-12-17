package com.daniel.raduca.countryflags.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.daniel.raduca.countryflags.R
import com.daniel.raduca.countryflags.ui.countries.CountriesApiStatus

/**
 * Sets data list to RecyclerView
 */
@BindingAdapter("data")
fun <T : Any> bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<T>
) {
    val adapter = recyclerView.adapter as GenericAdapter<T>
    adapter.submitList(data)
}

/**
 * Sets view visibility through data binding
 */
@BindingAdapter("visibility")
fun bindVisibility(
    view: View,
    isVisible: Boolean
) {
    if (isVisible) view.visibility = View.VISIBLE else view.visibility = View.GONE
}

/**
 * Uses Coil library to download and set the image
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_stop_sign)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: CountriesApiStatus) {
    when (status) {
        CountriesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CountriesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_stop_sign)
        }
        CountriesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("apiErrorMessage")
fun bindStatus(errorTextView: TextView, status: CountriesApiStatus) {
    when (status) {
        CountriesApiStatus.ERROR -> {
            errorTextView.visibility = View.VISIBLE
        }
        else -> {
            errorTextView.visibility = View.GONE
        }
    }
}
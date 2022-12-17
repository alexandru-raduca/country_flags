package com.daniel.raduca.countryflags.adapters

import android.opengl.Visibility
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("data")
fun <T : Any> bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<T>
) {
    val adapter = recyclerView.adapter as GenericAdapter<T>
    adapter.submitList(data)
}

@BindingAdapter("visibility")
fun setVisibility(
    view: View,
    isVisible: Boolean
) {
    if (isVisible) view.visibility = View.VISIBLE else view.visibility = View.GONE
}
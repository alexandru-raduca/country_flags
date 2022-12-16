package com.daniel.raduca.countryflags.adapters

import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.daniel.raduca.countryflags.model.Country

@BindingAdapter("listData", "listItemLayoutId")
fun <T : Any> bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<T>,
    @LayoutRes layoutId: Int,
    bindingInterface: BindingInterface<T>
) {
    recyclerView.adapter = GenericAdapter(data, layoutId, bindingInterface)
}
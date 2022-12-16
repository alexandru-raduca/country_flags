package com.daniel.raduca.countryflags.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

interface BindingInterface<T : Any> {
    fun bindData(item: T, view: View)
}

class GenericAdapter<T : Any>(
    private val data: List<T>, @LayoutRes val layoutId: Int,
    private val bindingInterface: BindingInterface<T>

) : RecyclerView.Adapter<GenericAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun <T : Any> bind(
            item: T,
            bindingInterface: BindingInterface<T>
        ) = bindingInterface.bindData(item, view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, bindingInterface)
    }

    override fun getItemCount(): Int = data.size
}

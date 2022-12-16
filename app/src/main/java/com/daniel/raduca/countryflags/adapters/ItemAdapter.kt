package com.daniel.raduca.countryflags.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daniel.raduca.countryflags.R
import com.daniel.raduca.countryflags.databinding.ListItemBinding
import com.daniel.raduca.countryflags.model.Country

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Country>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPhoto: Country) {
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

    }

    override fun getItemCount() = dataset.size
}


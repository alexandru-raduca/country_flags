package com.daniel.raduca.countryflags.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import com.daniel.raduca.countryflags.R
import com.daniel.raduca.countryflags.adapters.BindingHandler
import com.daniel.raduca.countryflags.adapters.GenericAdapter
import com.daniel.raduca.countryflags.databinding.FragmentCountriesBinding
import com.daniel.raduca.countryflags.databinding.ListItemBinding
import com.daniel.raduca.countryflags.model.Country

class CountriesFragment : Fragment(), BindingHandler<Country> {
    private val viewModel: CountriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCountriesBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.countries.adapter = GenericAdapter(
            R.layout.list_item,
            this,
            CountriesViewModel
        )

        return binding.root
    }

    override fun bindData(item: Country, view: View) {
        val itemBinding: ListItemBinding? = DataBindingUtil.getBinding(view)
        itemBinding?.let {
            it.item = item
            it.executePendingBindings()
        }
    }
}
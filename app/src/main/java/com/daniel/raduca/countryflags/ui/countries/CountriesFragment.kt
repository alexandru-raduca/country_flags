package com.daniel.raduca.countryflags.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.daniel.raduca.countryflags.R
import com.daniel.raduca.countryflags.adapters.BindingHandler
import com.daniel.raduca.countryflags.adapters.GenericAdapter
import com.daniel.raduca.countryflags.databinding.DetailBottomSheetBinding
import com.daniel.raduca.countryflags.databinding.FragmentCountriesBinding
import com.daniel.raduca.countryflags.databinding.ListItemBinding
import com.daniel.raduca.countryflags.model.Country
import com.daniel.raduca.countryflags.ui.countryDetail.DetailBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.NonDisposableHandle.parent

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
            it.cardView.setOnClickListener {
                val bottomSheet = DetailBottomSheet()

                // TODO: UGLY!!! after database configuration pass only the id. With that query the db and get all data not only the name
                val args = Bundle()
                args.putString("name", item.name?.common)
                args.putString("officialName", item.name?.official)

                bottomSheet.arguments = args
                bottomSheet.show(parentFragmentManager, DetailBottomSheet.TAG)
            }
            it.executePendingBindings()
        }
    }
}
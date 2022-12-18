package com.daniel.raduca.countryflags.ui.countryDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daniel.raduca.countryflags.R
import com.daniel.raduca.countryflags.databinding.DetailBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: DetailBottomSheetBinding = DetailBottomSheetBinding.inflate(inflater)
        val args = arguments

        // TODO: UGLY!!! get only the id and query the db for all the data. da fare ASAP!!!
        binding.name.text = args?.getString("name")
        binding.officialName.text = args?.getString("officialName")

        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    companion object {
        const val TAG = "DetailBottomSheet"
    }
}
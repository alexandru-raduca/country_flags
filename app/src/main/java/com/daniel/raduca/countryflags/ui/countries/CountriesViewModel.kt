package com.daniel.raduca.countryflags.ui.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.daniel.raduca.countryflags.model.Country
import com.daniel.raduca.countryflags.network.CountriesApi
import kotlinx.coroutines.launch

enum class CountriesApiStatus { LOADING, ERROR, DONE }

class CountriesViewModel : ViewModel() {

    private val _status = MutableLiveData<CountriesApiStatus>()
    val status: LiveData<CountriesApiStatus> = _status

    private val _countries = MutableLiveData<List<Country>>(listOf())
    val countries: LiveData<List<Country>> = _countries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _status.value = CountriesApiStatus.LOADING
            try {
                _countries.value = CountriesApi.retrofitService.getCountries()
                _status.value = CountriesApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CountriesApiStatus.ERROR
                _countries.value = listOf()
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }
}
package com.lais.harrypotter.view

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.lais.harrypotter.data.HarryPotterRepository
import com.lais.harrypotter.data.HarryPotterService
import com.lais.harrypotter.data.RetrofitAPI
import com.lais.harrypotter.data.response.HarryPotterCharactersResponse
import kotlinx.coroutines.launch

class HarryPotterListViewModel(private val repository: HarryPotterRepository): ViewModel() {

    private val _listCharacters: MutableLiveData<List<HarryPotterCharactersResponse>> = MutableLiveData()
    val listCharacters : LiveData<List<HarryPotterCharactersResponse>> = _listCharacters

    fun listCharacters(){
        viewModelScope.launch {
           val result = repository.getCharacters()
            _listCharacters.value = result
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val retrofit = RetrofitAPI.getRetrofit()
                val service = retrofit.create(HarryPotterService::class.java)
                val repository = HarryPotterRepository(service)

                return HarryPotterListViewModel(repository) as T
            }
        }
    }
}
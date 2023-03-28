package com.lais.harrypotter.characters.view

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.lais.harrypotter.characters.data.HarryPotterRepository
import com.lais.harrypotter.utils.HarryPotterService
import com.lais.harrypotter.utils.RetrofitAPI
import com.lais.harrypotter.characters.domain.HarryPotterListDomain
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import kotlinx.coroutines.launch

class HarryPotterListViewModel(private val repository: HarryPotterRepository): ViewModel() {

    private val _listCharacters: MutableLiveData<List<HarryPotterPresentation>> = MutableLiveData()
    val listCharacters : LiveData<List<HarryPotterPresentation>> = _listCharacters

    fun listCharacters(){
        viewModelScope.launch {
           val result = repository.getCharacters()
           val domain = HarryPotterListDomain()
            _listCharacters.value = domain.mapToPresentation(result)
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
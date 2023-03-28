package com.lais.harrypotter.spells.view

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.lais.harrypotter.utils.HarryPotterService
import com.lais.harrypotter.spells.data.SpellsRepository
import com.lais.harrypotter.spells.data.response.SpellsResponse
import com.lais.harrypotter.utils.RetrofitAPI
import kotlinx.coroutines.launch

class SpellsListViewModel (private val repository: SpellsRepository): ViewModel(){

    private val _listSpells: MutableLiveData<List<SpellsResponse>> = MutableLiveData()
    val listSpells: LiveData<List<SpellsResponse>> = _listSpells

    fun listSpells(){
        viewModelScope.launch {
            val result = repository.getSpell()
            _listSpells.value = result
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
                val repository = SpellsRepository(service)

                return SpellsListViewModel(repository) as T
            }
        }
    }
}
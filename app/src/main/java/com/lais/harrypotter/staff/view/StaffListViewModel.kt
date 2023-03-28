package com.lais.harrypotter.staff.view

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.lais.harrypotter.characters.data.HarryPotterRepository
import com.lais.harrypotter.characters.view.HarryPotterListViewModel
import com.lais.harrypotter.staff.data.StaffRepository
import com.lais.harrypotter.staff.domain.StaffListDomain
import com.lais.harrypotter.staff.domain.StaffPresentation
import com.lais.harrypotter.utils.HarryPotterService
import com.lais.harrypotter.utils.RetrofitAPI
import kotlinx.coroutines.launch

class StaffListViewModel(private  val repository: StaffRepository): ViewModel(){

    private val _listStaff: MutableLiveData<List<StaffPresentation>> = MutableLiveData()
    private  val liststaff: LiveData<List<StaffPresentation>> = _listStaff

    fun listStaff(){
        viewModelScope.launch {
            val result = repository.getStaff()
            val domain = StaffListDomain()
            _listStaff.value = domain.mapToPresentation(result)
        }
    }

    companion object{
        val  Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val retrofit = RetrofitAPI.getRetrofit()
                val service = retrofit.create(HarryPotterService::class.java)
                val repository = StaffRepository(service)

                return StaffListViewModel(repository) as T
            }
        }
    }
}



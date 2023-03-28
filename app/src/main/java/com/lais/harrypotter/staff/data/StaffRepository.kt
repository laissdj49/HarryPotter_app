package com.lais.harrypotter.staff.data

import com.lais.harrypotter.characters.data.response.HarryPotterCharactersResponse
import com.lais.harrypotter.staff.data.response.StaffResponse
import com.lais.harrypotter.utils.HarryPotterService

class StaffRepository(private val service: HarryPotterService){
    suspend fun getStaff(): List<StaffResponse>{
        return service.getStaff()
    }
}

interface CallBackListStaff{
    fun onSuccess(list: List<StaffResponse>)
    fun onError(error: Throwable)
}
package com.lais.harrypotter.spells.data

import com.lais.harrypotter.utils.HarryPotterService
import com.lais.harrypotter.spells.data.response.SpellsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpellsRepository(private val service: HarryPotterService) {

     suspend fun getAllSpells(CallBackListSpells: CallBackListSpells) {
        service.listSpells().enqueue(object : Callback<List<SpellsResponse>> {
            override fun onResponse(
                call: Call<List<SpellsResponse>>,
                response: Response<List<SpellsResponse>>
            ) {
                if (response.isSuccessful) {
                    CallBackListSpells.onSuccess(response.body().orEmpty())
                } else {
                    CallBackListSpells.onSuccess(emptyList())
                }
            }

            override fun onFailure(call: Call<List<SpellsResponse>>, t: Throwable) {
                CallBackListSpells.onError(t)

            }
        })
    }
    suspend fun getSpell(): List<SpellsResponse>{
        return service.getSpells()
    }


}

interface CallBackListSpells {
    fun onSuccess(list: List<SpellsResponse>)
    fun onError(error: Throwable)
}
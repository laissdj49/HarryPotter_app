package com.lais.harrypotter.utils

import com.lais.harrypotter.characters.data.response.HarryPotterCharactersResponse
import com.lais.harrypotter.spells.data.response.SpellsResponse
import com.lais.harrypotter.staff.data.response.StaffResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface necessaria para o retrofit gerar o codigo para realizar uma requisicao
 */

interface HarryPotterService {

    @GET("characters")
    fun listCharacters(): Call<List<HarryPotterCharactersResponse>>

    @GET("characters")
    suspend fun getCharacters(): List<HarryPotterCharactersResponse>

    @GET("spells")
    suspend fun listSpells(): Call<List<SpellsResponse>>

    @GET("spells")
    suspend fun getSpells(): List<SpellsResponse>

    @GET("staff")
    suspend fun listStaff(): Call<List<StaffResponse>>

    @GET("staff")
    suspend fun getStaff(): List<StaffResponse>

}
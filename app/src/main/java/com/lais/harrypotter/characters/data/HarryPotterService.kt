package com.lais.harrypotter.characters.data

import com.lais.harrypotter.characters.data.response.HarryPotterCharactersResponse
import com.lais.harrypotter.spells.data.response.SpellsResponse
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


}
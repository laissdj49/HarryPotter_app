package com.lais.harrypotter.data

import com.lais.harrypotter.data.response.HarryPotterCharactersResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface necessaria para o retrofit gerar o codigo para realizar uma requisicao
 */

interface HarryPotterService {

    @GET("characters")
    fun listCharacters(): Call<List<HarryPotterCharactersResponse>>


}
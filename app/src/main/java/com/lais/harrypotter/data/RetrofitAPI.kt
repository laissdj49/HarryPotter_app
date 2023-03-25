package com.lais.harrypotter.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    /**
    * Responsavel por definir a URL onde vou buscar os dados e por definir o converter utilizado
     * apos a configuracao acima retorna um objeto do tipo retrofit, configurado para o projeto.
    **/

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
    }
}
package com.lais.harrypotter.data

import androidx.lifecycle.LiveData
import com.lais.harrypotter.data.response.HarryPotterCharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * classe que interage com o codigo gerado pelo retrofit.
 * O enqueue() nos retorna uma resposta de forma assincrona.
 * O callBack() permite que seja acessado a resposta recebida da api
 */

class HarryPotterRepository(private val service: HarryPotterService) {

    fun getAllCharacters(callBackListHarryPotter: CallBackListHarryPotter) {
        service.listCharacters().enqueue(object : Callback<List<HarryPotterCharactersResponse>>{
            override fun onResponse(
                call: Call<List<HarryPotterCharactersResponse>>,
                response: Response<List<HarryPotterCharactersResponse>>
            ) {
                if(response.isSuccessful){
                    callBackListHarryPotter.onSuccess(response.body().orEmpty())
                }else{
                    callBackListHarryPotter.onSuccess(emptyList())
                }
            }

            override fun onFailure(call: Call<List<HarryPotterCharactersResponse>>, t: Throwable) {
                callBackListHarryPotter.onError(t)
            }
        })
    }

}
interface CallBackListHarryPotter{

    fun onSuccess(list: List<HarryPotterCharactersResponse>)
    fun onError(error: Throwable)
}
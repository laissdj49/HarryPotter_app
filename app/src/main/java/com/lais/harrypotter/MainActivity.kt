package com.lais.harrypotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lais.harrypotter.data.HarryPotterRepository
import com.lais.harrypotter.data.HarryPotterService
import com.lais.harrypotter.data.RetrofitAPI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = RetrofitAPI.getRetrofit()
        val service = retrofit.create(HarryPotterService::class.java)
        val repository = HarryPotterRepository(service)
        repository.getAllCharacters()
    }
}
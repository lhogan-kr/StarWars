package com.example.starwars.repository

import com.example.starwars.StarWarsApi
import com.example.starwars.models.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CharactersRepository @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(StarWarsApi::class.java)

    suspend fun getCharacters(): List<Character> = api.getCharacters().results
    suspend fun getCharacter(id: Int) = api.getCharacterDetails(id)

    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
    }
}
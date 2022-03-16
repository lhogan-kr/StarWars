package com.example.starwars

import com.example.starwars.models.Character
import com.example.starwars.models.CharactersResult
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {
    @GET("people/")
    suspend fun getCharacters(): CharactersResult

    @GET("people/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Character
}

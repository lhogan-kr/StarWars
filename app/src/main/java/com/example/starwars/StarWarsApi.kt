package com.example.starwars

import com.example.starwars.models.CharactersResult
import retrofit2.Call
import retrofit2.http.GET

interface StarWarsApi {
    @GET("people/")
    fun getAllCharacters(): Call<CharactersResult>
}
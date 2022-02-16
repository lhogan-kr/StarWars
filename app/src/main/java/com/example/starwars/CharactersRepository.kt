package com.example.starwars

import android.util.Log
import com.example.starwars.models.Character
import com.example.starwars.models.CharactersResult
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CharactersRepository @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacters(): List<Character> {
        var characters = listOf<Character>()

        val api = retrofit.create(StarWarsApi::class.java)

        api.getAllCharacters().enqueue(object : Callback<CharactersResult> {
            override fun onResponse(
                call: Call<CharactersResult>,
                response: Response<CharactersResult>
            ) {
//                Log.d("CharactersRepository", response.body()!!.results.toString())
                characters = response.body()!!.results
            }

            override fun onFailure(call: Call<CharactersResult>, t: Throwable) {
                Log.e("CharactersRepository", t.stackTraceToString())
            }
        })

        return characters
    }

    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
    }
}
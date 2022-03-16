package com.example.starwars.models

data class CharactersResult(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Character>
)

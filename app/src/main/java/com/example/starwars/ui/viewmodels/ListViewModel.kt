package com.example.starwars.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.starwars.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {

    var characters = mutableListOf<Character>()

    fun fillData() {
        repeat(10) {
            characters.addAll(
                listOf(
                    Character("Luke Skywalker", 24, "Tattoine", "Rebellion"),
                    Character("Darth Vader", 60, "Tattoine", "Empire")
                )
            )
        }
    }
}
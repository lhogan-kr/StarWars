package com.example.starwars.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.starwars.CharactersRepository
import com.example.starwars.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {

    @Inject lateinit var charactersRepository: CharactersRepository

    val characters = charactersRepository.getCharacters()
}
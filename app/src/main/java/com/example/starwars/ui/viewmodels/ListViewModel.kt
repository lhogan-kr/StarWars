package com.example.starwars.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.repository.CharactersRepository
import com.example.starwars.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val charactersRepository: CharactersRepository) :
    ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    fun fillData() {
        viewModelScope.launch {
            _characters.postValue(charactersRepository.getCharacters())
        }
    }

    fun getId(character: Character): Int {
        val sequence = character.url.split("/")
        val id = sequence[sequence.size - 2]
        return id.toInt()
    }
}
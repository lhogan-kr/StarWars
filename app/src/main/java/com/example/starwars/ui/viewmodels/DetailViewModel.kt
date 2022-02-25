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
class DetailViewModel @Inject constructor(private val charactersRepository: CharactersRepository) :
    ViewModel() {

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character

    fun fillData(id: Int) {
        viewModelScope.launch {
            _character.postValue(charactersRepository.getCharacter(id))
        }
    }
}
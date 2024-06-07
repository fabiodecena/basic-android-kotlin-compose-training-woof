package com.example.woof

import androidx.lifecycle.ViewModel
import com.example.woof.data.Dog
import com.example.woof.data.DogUiState
import com.example.woof.data.dogs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DogViewModel: ViewModel() {
    private val _dogUiState = MutableStateFlow(DogUiState())
    val dogUiState: StateFlow<DogUiState> = _dogUiState.asStateFlow()

    fun updateDogList(): List<Dog> {
        _dogUiState.value = DogUiState(dogsList = dogs)
        return _dogUiState.value.dogsList
    }
    fun toggleExpanded(dogName: Int) {
        _dogUiState.update { currentUiState ->
            val newExpandedDog = currentUiState.expandedDogName != dogName
            currentUiState.copy(
                expandedDogName = if (newExpandedDog) dogName else 0,
            )
        }
    }

}
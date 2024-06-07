package com.example.woof.data

data class DogUiState(

    val expandedDogName: Int = 0,
    val dogsList: List<Dog> = emptyList()
)
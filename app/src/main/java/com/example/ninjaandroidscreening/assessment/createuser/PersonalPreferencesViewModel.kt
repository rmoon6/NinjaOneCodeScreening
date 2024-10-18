package com.example.ninjaandroidscreening.assessment.createuser

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonalPreferencesViewModel : ViewModel() {

    val petList = listOf("Cat", "Dog", "None")
    val interestList = listOf("Books", "Movies", "Sports", "None")

    private val _selectedPet = MutableStateFlow<String?>(null)
    val selectedPet = _selectedPet.asStateFlow()

    fun updateSelectedPet(pet: String) {
        _selectedPet.value = pet
    }

    private val _selectedInterest = MutableStateFlow<String?>(null)
    val selectedInterest = _selectedInterest.asStateFlow()

    fun updateInterest(interest: String) {
        _selectedInterest.value = interest
    }

    private val _onNextButtonClicked = MutableStateFlow(false)
    val onNextButtonClicked = _onNextButtonClicked.asStateFlow()

}

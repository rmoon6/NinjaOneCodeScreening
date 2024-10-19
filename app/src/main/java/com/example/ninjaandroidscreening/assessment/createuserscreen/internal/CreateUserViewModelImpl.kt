package com.example.ninjaandroidscreening.assessment.createuserscreen.internal

import androidx.lifecycle.ViewModel
import com.example.ninjaandroidscreening.assessment.createuserscreen.CreateUserViewModel
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class CreateUserViewModelImpl : ViewModel(), CreateUserViewModel {

    override val enteredEmail = MutableStateFlow<String?>(null)
    private val enteredPassword = MutableStateFlow<String?>(null)
    override val selectedPet = MutableStateFlow<Pet?>(null)
    override val selectedInterest = MutableStateFlow<Interest?>(null)

    override fun onPersonalDataSubmitted(email: String, password: String) {
        enteredEmail.value = email
        enteredPassword.value = password
    }

    override fun onPersonalPreferencesSubmitted(pet: Pet, interest: Interest) {
        selectedPet.value = pet
        selectedInterest.value = interest
    }

    override fun onCreateUserConfirmed() {
        TODO("STOPSHIP")
    }
}
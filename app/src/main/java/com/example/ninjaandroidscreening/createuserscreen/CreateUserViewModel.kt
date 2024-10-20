package com.example.ninjaandroidscreening.createuserscreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ninjaandroidscreening.createuserscreen.internal.CreateUserViewModelImpl
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Pet
import kotlinx.coroutines.flow.StateFlow

interface CreateUserViewModel {

    val enteredEmail: StateFlow<String?>
    val selectedInterest: StateFlow<Interest?>
    val selectedPet: StateFlow<Pet?>

    fun onPersonalDataSubmitted(email: String, password: String)
    fun onPersonalPreferencesSubmitted(pet: Pet, interest: Interest)
    fun onCreateUserConfirmed()

    companion object {
        @Composable
        fun injectIntoComposable(): CreateUserViewModel {
            return hiltViewModel<CreateUserViewModelImpl>()
        }
    }
}

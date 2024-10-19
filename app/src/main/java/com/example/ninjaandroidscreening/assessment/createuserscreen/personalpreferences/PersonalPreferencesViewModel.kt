package com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.internal.PersonalPreferencesViewModelImpl
import kotlinx.coroutines.flow.StateFlow

interface PersonalPreferencesViewModel {

    val selectedPet: StateFlow<Pet?>
    val selectedInterest: StateFlow<Interest?>
    val isSubmissionAllowed: StateFlow<Boolean>

    fun petSelected(pet: Pet)
    fun interestSelected(interest: Interest)

    companion object {
        @Composable
        fun injectIntoComposable(): PersonalPreferencesViewModel {
            return hiltViewModel<PersonalPreferencesViewModelImpl>()
        }
    }
}

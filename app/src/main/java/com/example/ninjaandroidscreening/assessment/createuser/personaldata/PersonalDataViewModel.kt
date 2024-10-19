package com.example.ninjaandroidscreening.assessment.createuser.personaldata

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.StateFlow

interface PersonalDataViewModel {

    val enteredEmail: StateFlow<String>
    val enteredPassword: StateFlow<String>
    val isSubmissionAllowed: StateFlow<Boolean>

    fun emailUpdated(email: String)
    fun passwordUpdated(password: String)

    companion object {
        @Composable
        fun injectIntoComposable(): PersonalDataViewModel {
            return hiltViewModel<PersonalDataViewModelImpl>()
        }
    }
}

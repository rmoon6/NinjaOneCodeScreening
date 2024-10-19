package com.example.ninjaandroidscreening.assessment.createuser.personaldata

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PersonalDataViewModelImpl @Inject constructor(
    private val dataValidation: ValidatePersonalDataUseCase
) : ViewModel(), PersonalDataViewModel {

    override val enteredEmail: StateFlow<String>
        get() = TODO("Not yet implemented")
    override val enteredPassword: StateFlow<String>
        get() = TODO("Not yet implemented")
    override val isSubmissionAllowed: Boolean
        get() = TODO("Not yet implemented")

    override fun usernameUpdated(username: String) {
        TODO("Not yet implemented")
    }

    override fun passwordUpdated(password: String) {
        TODO("Not yet implemented")
    }
}

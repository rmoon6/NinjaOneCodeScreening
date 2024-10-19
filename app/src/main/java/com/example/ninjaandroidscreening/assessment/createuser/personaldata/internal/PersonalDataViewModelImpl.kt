package com.example.ninjaandroidscreening.assessment.createuser.personaldata.internal

import androidx.lifecycle.ViewModel
import com.example.ninjaandroidscreening.assessment.createuser.personaldata.PersonalDataViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PersonalDataViewModelImpl @Inject constructor(
    private val dataValidation: ValidatePersonalDataUseCase
) : ViewModel(), PersonalDataViewModel {

    override val enteredEmail = MutableStateFlow("")
    override val enteredPassword = MutableStateFlow("")
    override val isSubmissionAllowed = MutableStateFlow(false)

    override fun emailUpdated(email: String) {
        enteredEmail.value = email
        isSubmissionAllowed.value = dataValidation.invoke(enteredEmail.value, enteredPassword.value)
    }

    override fun passwordUpdated(password: String) {
        enteredPassword.value = password
        isSubmissionAllowed.value = dataValidation.invoke(enteredEmail.value, enteredPassword.value)
    }
}

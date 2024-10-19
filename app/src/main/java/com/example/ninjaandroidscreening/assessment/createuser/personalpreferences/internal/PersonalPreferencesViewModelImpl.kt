package com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.internal

import androidx.lifecycle.ViewModel
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.PersonalPreferencesViewModel
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class PersonalPreferencesViewModelImpl : ViewModel(), PersonalPreferencesViewModel {

    override val selectedPet = MutableStateFlow<Pet?>(null)
    override val selectedInterest = MutableStateFlow<Interest?>(null)
    override val isSubmissionAllowed = MutableStateFlow(false)

    override fun petSelected(pet: Pet) {
        selectedPet.value = pet
        isSubmissionAllowed.value = selectedPet.value != null && selectedInterest.value != null
    }

    override fun interestSelected(interest: Interest) {
        selectedInterest.value = interest
        isSubmissionAllowed.value = selectedPet.value != null && selectedInterest.value != null
    }
}

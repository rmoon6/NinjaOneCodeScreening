package com.example.ninjaandroidscreening.assessment.createuser.internal

import androidx.lifecycle.ViewModel
import com.example.ninjaandroidscreening.assessment.createuser.CreateUserViewModel
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.Pet
import kotlinx.coroutines.flow.StateFlow

class CreateUserViewModelImpl : ViewModel(), CreateUserViewModel {

    override val enteredEmail: StateFlow<String?>
        get() = TODO("Not yet implemented")
    override val selectedInterest: StateFlow<Interest?>
        get() = TODO("Not yet implemented")
    override val selectedPet: StateFlow<Pet?>
        get() = TODO("Not yet implemented")

    override fun onPersonalDataSubmitted(email: String, password: String) {
        TODO("STOPSHIP")
    }

    override fun onPersonalPreferencesSubmitted(pet: Pet, interest: Interest) {
        TODO("STOPSHIP")
    }

    override fun onCreateUserConfirmed() {
        TODO("STOPSHIP")
    }
}

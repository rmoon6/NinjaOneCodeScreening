package com.example.ninjaandroidscreening.createuserscreen.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ninjaandroidscreening.createuserscreen.CreateUserViewModel
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Pet
import com.example.ninjaandroidscreening.userdb.UserDao
import com.example.ninjaandroidscreening.userdb.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModelImpl @Inject constructor(
    private val userDao: UserDao
) : ViewModel(), CreateUserViewModel {

    override val enteredEmail = MutableStateFlow<String?>(null)
    override val selectedPet = MutableStateFlow<Pet?>(null)
    override val selectedInterest = MutableStateFlow<Interest?>(null)

    override fun onPersonalDataSubmitted(email: String, password: String) {
        enteredEmail.value = email
    }

    override fun onPersonalPreferencesSubmitted(pet: Pet, interest: Interest) {
        selectedPet.value = pet
        selectedInterest.value = interest
    }

    override fun onCreateUserConfirmed() {
        viewModelScope.launch { userDao.insertUser(requireUser()) }
    }

    private fun requireUser(): UserEntity {
        return UserEntity(
            email = requireNotNull(enteredEmail.value) { "Trying to create a user when entered email is null!!" },
            pet = requireNotNull(selectedPet.value) { "Trying to create a user when selected pet is null!!" },
            interest = requireNotNull(selectedInterest.value) { "Trying to create a user when selected interest is null!!" },
        )
    }
}

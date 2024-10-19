package com.example.ninjaandroidscreening.assessment.createuser.personaldata

class ValidatePersonalDataUseCase {

    operator fun invoke(email: String, password: String): Boolean {
        return email.isEmailValid() && password.isPasswordValid()
    }

    private fun String.isEmailValid(): Boolean {
        TODO("STOPSHIP")
    }

    private fun String.isPasswordValid(): Boolean {
        TODO("STOPSHIP")
    }
}

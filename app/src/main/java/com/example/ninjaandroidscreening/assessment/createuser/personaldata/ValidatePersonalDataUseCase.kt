package com.example.ninjaandroidscreening.assessment.createuser.personaldata

class ValidatePersonalDataUseCase {

    operator fun invoke(username: String, password: String): Boolean {
        return username.isUsernameValid() && password.isPasswordValid()
    }

    private fun String.isUsernameValid(): Boolean {
        TODO("STOPSHIP")
    }

    private fun String.isPasswordValid(): Boolean {
        TODO("STOPSHIP")
    }
}

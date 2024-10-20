package com.example.ninjaandroidscreening.createuserscreen.personaldata.internal

class ValidatePersonalDataUseCase {

    operator fun invoke(email: String, password: String): Boolean {
        return email.isEmailValid() && password.isPasswordValid()
    }

    private fun String.isEmailValid(): Boolean {
        return isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun String.isPasswordValid(): Boolean {
        val containsLetter = any { it.isLetter() }
        val containsDigit = any { it.isDigit() }
        return length >= 6 && containsLetter && containsDigit
    }
}

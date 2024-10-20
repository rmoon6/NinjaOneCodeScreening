package com.example.ninjaandroidscreening.createuserscreen.personaldata.internal

class ValidatePersonalDataUseCase {

    operator fun invoke(email: String, password: String): Boolean {
        return email.isEmailValid() && password.isPasswordValid()
    }

    private fun String.isEmailValid(): Boolean {
        return isNotEmpty() && matches(EMAIL_REGEX_STRING.toRegex())
    }

    private fun String.isPasswordValid(): Boolean {
        val containsLetter = any { it.isLetter() }
        val containsDigit = any { it.isDigit() }
        return length >= 6 && containsLetter && containsDigit
    }

    companion object {
        private const val EMAIL_REGEX_STRING = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    }
}

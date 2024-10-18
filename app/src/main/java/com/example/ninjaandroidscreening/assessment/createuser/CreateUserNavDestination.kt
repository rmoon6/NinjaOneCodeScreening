package com.example.ninjaandroidscreening.assessment.createuser

internal enum class CreateUserNavDestination {
    PERSONAL_DATA,
    PERSONAL_PREFERENCES,
    CONFIRM_CREATE_USER;

    fun routeName(): String {
        return name
    }
}

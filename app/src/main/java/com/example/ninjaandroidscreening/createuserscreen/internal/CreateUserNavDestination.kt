package com.example.ninjaandroidscreening.createuserscreen.internal

internal enum class CreateUserNavDestination {
    PERSONAL_DATA,
    PERSONAL_PREFERENCES,
    CONFIRM_CREATE_USER;

    fun routeName(): String {
        return name
    }
}

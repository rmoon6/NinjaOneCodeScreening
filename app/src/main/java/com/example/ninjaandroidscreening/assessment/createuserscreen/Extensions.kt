package com.example.ninjaandroidscreening.assessment.createuserscreen

import androidx.navigation.NavController
import com.example.ninjaandroidscreening.assessment.createuserscreen.internal.CreateUserNavDestination

fun NavController.navigateToPersonalDataScreen() {
    navigate(CreateUserNavDestination.PERSONAL_DATA.routeName())
}

fun NavController.navigateToPersonalPreferencesScreen() {
    navigate(CreateUserNavDestination.PERSONAL_PREFERENCES.routeName())
}

fun NavController.navigateToConfirmCreateUserScreen() {
    navigate(CreateUserNavDestination.CONFIRM_CREATE_USER.routeName())
}
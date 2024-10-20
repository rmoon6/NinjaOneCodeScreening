package com.example.ninjaandroidscreening.createuserscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.createuserscreen.confirmusercreate.ConfirmCreateUserScreen
import com.example.ninjaandroidscreening.createuserscreen.internal.CreateUserNavDestination
import com.example.ninjaandroidscreening.createuserscreen.personaldata.PersonalDataScreen
import com.example.ninjaandroidscreening.createuserscreen.personaldata.PersonalDataScreenCallbacks
import com.example.ninjaandroidscreening.createuserscreen.personaldata.PersonalDataViewModel
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.PersonalPreferencesScreen
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.PersonalPreferencesViewModel

@Composable
fun CreateUserScreen(
    modifier: Modifier,
    viewModel: CreateUserViewModel,
    onUserCreated: () -> Unit
) {
    val navController = rememberNavController()
    val enteredEmail by viewModel.enteredEmail.collectAsState()
    val selectedPet by viewModel.selectedPet.collectAsState()
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CreateUserNavDestination.PERSONAL_DATA.routeName()
    ) {
        composable(CreateUserNavDestination.PERSONAL_DATA.routeName()) {
            val callbacks = object : PersonalDataScreenCallbacks {
                override fun userSubmittedPersonalData(email: String, password: String) {
                    viewModel.onPersonalDataSubmitted(email, password)
                    navController.navigateToPersonalPreferencesScreen()
                }
            }
            PersonalDataScreen(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                viewModel = PersonalDataViewModel.injectIntoComposable(),
                callbacks = callbacks
            )
        }

        composable(CreateUserNavDestination.PERSONAL_PREFERENCES.routeName()) {
            PersonalPreferencesScreen(
                modifier = Modifier,
                viewModel = PersonalPreferencesViewModel.injectIntoComposable(),
                onPreferencesSubmitted = { pet, interest ->
                    viewModel.onPersonalPreferencesSubmitted(pet, interest)
                    navController.navigateToConfirmCreateUserScreen()
                },
            )
        }

        composable(CreateUserNavDestination.CONFIRM_CREATE_USER.routeName()) {
            ConfirmCreateUserScreen(
                email = requireNotNull(enteredEmail) { "Attempt to go to confirm user screen without an email!!" },
                pet = requireNotNull(selectedPet) { "Attempt to go to confirm user screen without a pet selected!!" },
                interest = requireNotNull(selectedInterest) { "Attempt to go to confirm user screen without an interest selected!!" },
                onUserCreateConfirmed = {
                    viewModel.onCreateUserConfirmed()
                    onUserCreated.invoke()
                }
            )
        }
    }
}

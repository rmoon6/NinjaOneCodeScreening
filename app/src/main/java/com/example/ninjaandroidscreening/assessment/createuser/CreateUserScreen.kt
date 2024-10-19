package com.example.ninjaandroidscreening.assessment.createuser

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.assessment.createuser.confirmusercreate.ConfirmCreateUserScreen
import com.example.ninjaandroidscreening.assessment.createuser.personaldata.PersonalDataScreen
import com.example.ninjaandroidscreening.assessment.createuser.personaldata.PersonalDataScreenCallbacks
import com.example.ninjaandroidscreening.assessment.createuser.personaldata.PersonalDataViewModel
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.PersonalPreferencesScreen
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.PersonalPreferencesViewModel

@Composable
fun CreateUserScreen(modifier: Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationGraph(
                    modifier = Modifier.padding(padding),
                    navController = navController
                )
            }
        }
    )
}

@Composable
private fun NavigationGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CreateUserNavDestination.PERSONAL_DATA.routeName()
    ) {
        composable(CreateUserNavDestination.PERSONAL_DATA.routeName()) {
            val callbacks = object : PersonalDataScreenCallbacks {
                override fun userSubmittedPersonalData(email: String, password: String) {
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
                    navController.navigateToConfirmCreateUserScreen()
                },
            )
        }

        composable(CreateUserNavDestination.CONFIRM_CREATE_USER.routeName()) {
            ConfirmCreateUserScreen(
                email = "placeholder email",    // TODO STOPSHIP replaceme with the real deal!!
                pet = "placeholder pet",    // TODO STOPSHIP replaceme with the real deal!!
                interest = "placeholder interest",  // TODO STOPSHIP replaceme with the real deal!!
                onUserCreateConfirmed = {}  // TODO STOPSHIP replaceme with the real deal!!
            )
        }
    }
}

package com.example.ninjaandroidscreening.assessment.createuser

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.assessment.createuser.confirmusercreate.ConfirmCreateUserScreen
import com.example.ninjaandroidscreening.assessment.createuser.personaldata.PersonalDataScreen
import com.example.ninjaandroidscreening.assessment.createuser.personalpreferences.PersonalPreferencesScreen

@Composable
fun CreateUserScreen(modifier: Modifier) {
    val navController = rememberNavController()
    Scaffold(
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
            PersonalDataScreen { navController.navigateToPersonalPreferencesScreen() }
        }

        composable(CreateUserNavDestination.PERSONAL_PREFERENCES.routeName()) {
            PersonalPreferencesScreen { navController.navigateToConfirmCreateUserScreen() }
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

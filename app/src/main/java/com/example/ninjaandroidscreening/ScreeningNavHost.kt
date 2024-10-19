package com.example.ninjaandroidscreening

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.assessment.createuserscreen.CreateUserScreen
import com.example.ninjaandroidscreening.assessment.createuserscreen.CreateUserViewModel
import com.example.ninjaandroidscreening.ui.dashboard.DashboardScreen
import com.example.ninjaandroidscreening.ui.dashboard.DashboardViewModel

@Composable
fun ScreeningNavHost(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ScreeningNavDestination.DASHBOARD.routeName(),
    ) {
        composable(ScreeningNavDestination.DASHBOARD.routeName()) {
            DashboardScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = DashboardViewModel.injectIntoComposable(),
                addUserSelected = { navController.navigate(ScreeningNavDestination.CREATE_USER.routeName()) }
            )
        }

        composable(ScreeningNavDestination.CREATE_USER.routeName()) {
            CreateUserScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = CreateUserViewModel.injectIntoComposable()
            )
        }
    }
}

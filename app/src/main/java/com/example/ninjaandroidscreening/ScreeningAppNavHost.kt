package com.example.ninjaandroidscreening

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.createuserscreen.CreateUserScreen
import com.example.ninjaandroidscreening.createuserscreen.CreateUserViewModel
import com.example.ninjaandroidscreening.dashboardscreen.DashboardScreen
import com.example.ninjaandroidscreening.dashboardscreen.DashboardViewModel

@Composable
fun ScreeningNavHost(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ScreeningAppNavDestination.DASHBOARD.routeName(),
    ) {
        composable(ScreeningAppNavDestination.DASHBOARD.routeName()) {
            DashboardScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = DashboardViewModel.injectIntoComposable(),
                addUserSelected = { navController.navigate(ScreeningAppNavDestination.CREATE_USER.routeName()) }
            )
        }

        composable(ScreeningAppNavDestination.CREATE_USER.routeName()) {
            CreateUserScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = CreateUserViewModel.injectIntoComposable(),
                onUserCreated = { navController.navigateUp() }
            )
        }
    }
}

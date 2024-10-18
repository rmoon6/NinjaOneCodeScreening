package com.example.ninjaandroidscreening

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.ui.dashboard.DashboardScreen

@Composable
fun ScreeningNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "DashboardScreen",
) {
    NavHost(
        navController = navController,
        route = "Route",
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable("DashboardScreen") {
            DashboardScreen(
                onAddNewUserButtonClick = {
                    // Navigate to Nested Add User Graph
                },
            )
        }
    }
}

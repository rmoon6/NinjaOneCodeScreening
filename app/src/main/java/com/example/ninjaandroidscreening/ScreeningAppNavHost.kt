package com.example.ninjaandroidscreening

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ninjaandroidscreening.createuserscreen.CreateUserScreen
import com.example.ninjaandroidscreening.createuserscreen.CreateUserViewModel
import com.example.ninjaandroidscreening.dashboardscreen.DashboardScreen
import com.example.ninjaandroidscreening.dashboardscreen.DashboardViewModel
import kotlinx.coroutines.launch

@Composable
fun ScreeningApp(modifier: Modifier) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreeningAppNavDestination.DASHBOARD.routeName(),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(ScreeningAppNavDestination.DASHBOARD.routeName()) {
                DashboardScreen(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = DashboardViewModel.injectIntoComposable(),
                    addUserSelected = {
                        navController.navigate(ScreeningAppNavDestination.CREATE_USER.routeName())
                    }
                )
            }

            composable(ScreeningAppNavDestination.CREATE_USER.routeName()) {
                CreateUserScreen(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = CreateUserViewModel.injectIntoComposable(),
                    onUserCreated = {
                        navController.navigateUp()
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = "User created successfully!",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                )
            }
        }
    }
}

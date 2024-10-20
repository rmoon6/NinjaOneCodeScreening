package com.example.ninjaandroidscreening.dashboardscreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ninjaandroidscreening.userdb.UserEntity
import com.example.ninjaandroidscreening.dashboardscreen.internal.DashboardViewModelImpl
import kotlinx.coroutines.flow.StateFlow

interface DashboardViewModel {

    val users: StateFlow<List<UserEntity>>

    companion object {
        @Composable
        fun injectIntoComposable(): DashboardViewModel {
            return hiltViewModel<DashboardViewModelImpl>()
        }
    }
}

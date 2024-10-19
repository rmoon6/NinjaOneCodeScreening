package com.example.ninjaandroidscreening.ui.dashboard

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity
import com.example.ninjaandroidscreening.ui.dashboard.internal.DashboardViewModelImpl
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

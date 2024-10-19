package com.example.ninjaandroidscreening.ui.dashboard

import androidx.compose.runtime.Composable
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity
import kotlinx.coroutines.flow.StateFlow

interface DashboardViewModel {

    val users: StateFlow<List<UserEntity>>

    companion object {
        @Composable
        fun injectIntoComposable(): DashboardViewModel {
            TODO("STOPSHIP")
        }
    }
}


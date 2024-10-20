package com.example.ninjaandroidscreening.dashboardscreen.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ninjaandroidscreening.userdb.UserDao
import com.example.ninjaandroidscreening.userdb.UserEntity
import com.example.ninjaandroidscreening.dashboardscreen.DashboardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModelImpl @Inject constructor(
    private val userDao: UserDao
) : ViewModel(), DashboardViewModel {

    override val users = MutableStateFlow(listOf<UserEntity>())

    init {
        viewModelScope.launch {
            userDao
                .getAllUsers()
                .collect { users.value = it }
        }
    }
}

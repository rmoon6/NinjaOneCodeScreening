package com.example.ninjaandroidscreening.ui.dashboard.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ninjaandroidscreening.assessment.userdb.UserDao
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity
import com.example.ninjaandroidscreening.ui.dashboard.DashboardViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashboardViewModelImpl(private val userDao: UserDao) : ViewModel(), DashboardViewModel {

    override val users = MutableStateFlow(listOf<UserEntity>())

    init {
        viewModelScope.launch { users.value = userDao.getAllUsers() }
    }
}

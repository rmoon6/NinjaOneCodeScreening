package com.example.ninjaandroidscreening

enum class ScreeningAppNavDestination {
    DASHBOARD,
    CREATE_USER;

    fun routeName(): String {
        return name
    }
}

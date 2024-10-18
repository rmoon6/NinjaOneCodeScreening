package com.example.ninjaandroidscreening

enum class ScreeningNavDestination {
    DASHBOARD,
    CREATE_USER;

    fun routeName(): String {
        return name
    }
}

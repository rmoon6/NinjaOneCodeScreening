package com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences

enum class Interest {
    SPORTS,
    MUSIC,
    TRAVEL,
    READING,
    GAMING;

    val displayName: String get() = when (this) {
        SPORTS -> "Sports"
        MUSIC -> "Music"
        TRAVEL -> "Travel"
        READING -> "Reading"
        GAMING -> "Gaming"
    }
}

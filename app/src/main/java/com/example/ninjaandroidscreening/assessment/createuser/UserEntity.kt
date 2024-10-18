package com.example.ninjaandroidscreening.assessment.createuser

import androidx.room.PrimaryKey

data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val pet: String,
    val interest: String
)

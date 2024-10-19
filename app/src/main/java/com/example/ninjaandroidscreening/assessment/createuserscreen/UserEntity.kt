package com.example.ninjaandroidscreening.assessment.createuserscreen

import androidx.room.PrimaryKey
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Pet

data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val pet: Pet,
    val interest: Interest
)

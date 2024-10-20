package com.example.ninjaandroidscreening.userdb

import androidx.room.TypeConverter
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Pet

class UserTypeConverters {

    @TypeConverter
    fun fromPet(pet: Pet): String {
        return pet.name
    }

    @TypeConverter
    fun toPet(petName: String): Pet {
        return Pet.valueOf(petName)
    }

    @TypeConverter
    fun fromInterest(interest: Interest): String {
        return interest.name
    }

    @TypeConverter
    fun toInterest(interestName: String): Interest {
        return Interest.valueOf(interestName)
    }
}

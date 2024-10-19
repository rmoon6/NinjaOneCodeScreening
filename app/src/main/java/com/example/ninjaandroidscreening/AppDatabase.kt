package com.example.ninjaandroidscreening

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ninjaandroidscreening.assessment.userdb.UserDao
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity
import com.example.ninjaandroidscreening.assessment.userdb.UserTypeConverters

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(UserTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

package com.example.ninjaandroidscreening.userdb

import com.example.ninjaandroidscreening.ScreeningAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserDbModule {

    @Provides
    fun provideUserDao(database: ScreeningAppDatabase): UserDao {
        return database.userDao()
    }
}

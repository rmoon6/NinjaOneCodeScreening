package com.example.ninjaandroidscreening.assessment.di

import android.content.Context
import androidx.room.Room
import com.example.ninjaandroidscreening.AppDatabase
import com.example.ninjaandroidscreening.assessment.createuserscreen.personaldata.internal.ValidatePersonalDataUseCase
import com.example.ninjaandroidscreening.assessment.userrepository.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideValidatePersonalDataUseCase(): ValidatePersonalDataUseCase {
        return ValidatePersonalDataUseCase()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
}

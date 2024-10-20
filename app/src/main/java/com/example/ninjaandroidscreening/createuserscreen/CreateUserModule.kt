package com.example.ninjaandroidscreening.createuserscreen

import com.example.ninjaandroidscreening.createuserscreen.personaldata.internal.ValidatePersonalDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CreateUserModule {

    @Provides
    @Singleton
    fun provideValidatePersonalDataUseCase(): ValidatePersonalDataUseCase {
        return ValidatePersonalDataUseCase()
    }
}

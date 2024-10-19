package com.example.ninjaandroidscreening.assessment.di

import com.example.ninjaandroidscreening.assessment.createuser.personaldata.ValidatePersonalDataUseCase
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
}

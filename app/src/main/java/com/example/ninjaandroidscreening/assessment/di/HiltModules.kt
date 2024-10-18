package com.example.ninjaandroidscreening.assessment.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

}

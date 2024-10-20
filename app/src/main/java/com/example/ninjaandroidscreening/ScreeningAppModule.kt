package com.example.ninjaandroidscreening

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScreeningAppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): ScreeningAppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ScreeningAppDatabase::class.java,
            name = "screening_app_database"
        ).build()
    }
}

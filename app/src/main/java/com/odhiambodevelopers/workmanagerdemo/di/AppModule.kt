package com.odhiambodevelopers.workmanagerdemo.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.odhiambodevelopers.workmanagerdemo.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabases(@ApplicationContext context: Context):MoviesDatabase {
        return Room.databaseBuilder(context.applicationContext, MoviesDatabase::class.java, "movies")
            .build()

    }
}
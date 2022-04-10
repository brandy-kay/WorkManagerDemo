package com.odhiambodevelopers.workmanagerdemo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 2)
abstract class MoviesDatabase : RoomDatabase(){
    abstract val dao:MoviesDao
}
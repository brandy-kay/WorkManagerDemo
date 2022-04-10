package com.odhiambodevelopers.workmanagerdemo.database

import androidx.room.*

@Dao
interface MoviesDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies:Movie)

    @Query("SELECT * FROM movie ORDER BY RANDOM() LIMIT 1")
    suspend fun getMovie(): Movie?
}
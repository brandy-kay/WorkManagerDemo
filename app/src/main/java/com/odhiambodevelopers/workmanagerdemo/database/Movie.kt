package com.odhiambodevelopers.workmanagerdemo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    val name:String,
    val description:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int ?= null

)

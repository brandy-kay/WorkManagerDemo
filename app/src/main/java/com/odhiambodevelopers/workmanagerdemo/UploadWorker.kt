package com.odhiambodevelopers.workmanagerdemo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.odhiambodevelopers.workmanagerdemo.database.Movie
import com.odhiambodevelopers.workmanagerdemo.database.MoviesDatabase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltWorker
class UploadWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParameters: WorkerParameters,
    private val moviesDatabase: MoviesDatabase
) : CoroutineWorker(appContext,workerParameters) {
    override suspend fun doWork(): Result {
    /*  *//*  CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
        }*//*

        //Toast.makeText(applicationContext, "Happy learning", Toast.LENGTH_SHORT).show()
        val name = inputData.getString("NAME") ?: "No name"
        Log.d(TAG, "doWork: $name")
        return Result.success()*/
        return try {
            moviesDatabase.dao.insertMovies(Movie("julie","Julie and the phantoms"))
            Result.success()
        }catch (exception:Exception){
            Result.failure()
        }

    }

    companion object{
        const val UPLOAD_WORK = "UPLOAD_WORK"
        private const val TAG = "UploadWorker"
    }
}
package com.odhiambodevelopers.workmanagerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.*
import com.odhiambodevelopers.workmanagerdemo.UploadWorker.Companion.UPLOAD_WORK
import com.odhiambodevelopers.workmanagerdemo.ui.theme.WorkManagerDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkManagerDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    val constraint = Constraints.Builder()
                        .setRequiresBatteryNotLow(true)
                        .build()

                    val uploadWorker:PeriodicWorkRequest = PeriodicWorkRequestBuilder<UploadWorker>(15,TimeUnit.MINUTES)
                        .setConstraints(constraint)
                        .setInputData(workDataOf("NAME" to "Brandy"))
                        .build()

                    WorkManager.getInstance(context)
                        .enqueueUniquePeriodicWork(UPLOAD_WORK,ExistingPeriodicWorkPolicy.KEEP,uploadWorker)


                }
            }
        }
    }
}



/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkManagerDemoTheme {
        Greeting("Android")
    }
}*/

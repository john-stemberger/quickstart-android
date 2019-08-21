package com.google.firebase.quickstart.perfmon

import android.app.Application
import android.os.StrictMode
import android.util.Log

class CustomApp : Application() {
    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            Log.e("JOHN", "strict mode")
            StrictMode.setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder()
//                            .detectDiskReads()
//                            .detectDiskWrites()
                            .detectAll()
                            .penaltyLog()
                            .build()
            )
            StrictMode.setVmPolicy(
                    StrictMode.VmPolicy.Builder()
                            .detectLeakedSqlLiteObjects()
                            .detectLeakedClosableObjects()
                            .penaltyLog()
                            .penaltyDeath()
                            .build()
            )
        }
        super.onCreate()
    }

}
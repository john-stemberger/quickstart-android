package com.google.firebase.quickstart.perfmon.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.google.firebase.quickstart.perfmon.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.CountDownLatch

class MainActivity : AppCompatActivity() {

    private val numStartupTasks = CountDownLatch(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Crashlytics.getInstance().crash() // Force a crash
        }

    }

    companion object {
        private const val TAG = "MainActivity"

        private const val DEFAULT_CONTENT_FILE = "default_content.txt"
        private const val CONTENT_FILE = "content.txt"
        private const val IMAGE_URL =
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"

        private const val STARTUP_TRACE_NAME = "startup_trace"
        private const val REQUESTS_COUNTER_NAME = "requests sent"
        private const val FILE_SIZE_COUNTER_NAME = "file size"
    }
}

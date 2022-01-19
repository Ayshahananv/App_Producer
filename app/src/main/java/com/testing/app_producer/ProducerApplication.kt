package com.testing.app_producer

import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.testing.app_producer.controller.xtsBuilder

class ProducerApplication : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Aysha", "onCreate: created")
        xtsBuilder.build(this)
        Log.d("Aysha", "onCreate: ended")
    }

    override fun onDestroy() {
        Log.d("Aysha", "onDestroy: ")
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }
}
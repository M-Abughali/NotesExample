package com.ghalym.notesexample

import android.app.Application

class MyApp : Application() {


    companion object {
        private lateinit var Instance: Application;

        public fun getInstance(): Application {
            return Instance;
        }
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this;

    }
}
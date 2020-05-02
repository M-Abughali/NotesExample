package com.ghalym.notesexample

import android.app.Application
import com.ghalym.notesexample.di.AppModule
import com.ghalym.notesexample.di.DaggerNoteComponent
import com.ghalym.notesexample.di.NoteComponent

class MyApp : Application() {


    companion object {
        private lateinit var noteComponent: NoteComponent;
        private lateinit var Instance: Application;

        public fun getInstance(): Application {
            return Instance;
        }
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this;
        noteComponent = DaggerNoteComponent.builder().appModule(AppModule(this)).build();
    }
}
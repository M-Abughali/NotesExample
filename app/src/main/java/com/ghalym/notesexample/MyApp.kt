package com.ghalym.notesexample

import android.app.Application
import com.ghalym.notesexample.di.AppModule
import com.ghalym.notesexample.di.DaggerNoteComponent
import com.ghalym.notesexample.di.NoteComponent

class MyApp : Application() {
    private lateinit var noteComponent: NoteComponent;

     public fun getNoteComponent(): NoteComponent {
        return noteComponent;
    }
    companion object {
        private lateinit var Instance: MyApp;
         fun getInstance(): MyApp {
            return Instance;
        }
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this;
     noteComponent = DaggerNoteComponent.builder().appModule(AppModule(this)).build();
    }
}
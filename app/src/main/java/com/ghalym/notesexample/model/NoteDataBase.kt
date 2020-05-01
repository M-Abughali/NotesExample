package com.ghalym.notesexample.model

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase() : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao


    companion object {
        @Volatile
        private var Instance: RoomDatabase? = null
        fun getDataBase(application: Application): RoomDatabase? {
            synchronized(this) {
                if (Instance == null)
                    Instance =
                        Room.databaseBuilder(application, NoteDataBase::class.java, "noteDb")
                            .build()
            }
            return Instance
        }

    }


}
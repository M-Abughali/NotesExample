package com.ghalym.notesexample.model

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase() : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao


    companion object {
        private lateinit var Instance: RoomDatabase
        fun getDataBase(application: Application): RoomDatabase {
            if (Instance == null)
                Instance =
                    Room.databaseBuilder(application, NoteDataBase::class.java, "noteDb").build();


            return Instance;
        }

    }


}
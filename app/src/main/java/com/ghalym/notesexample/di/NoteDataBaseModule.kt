package com.ghalym.notesexample.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase.Companion.DATABASE_NAME
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteDao
import com.ghalym.notesexample.model.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NoteDataBaseModule {

    @Singleton
    @Provides
    fun getNoteDataBase(application: Application): NoteDataBase {
        return Room.databaseBuilder(application, NoteDataBase::class.java, DATABASE_NAME).build()
    }

}
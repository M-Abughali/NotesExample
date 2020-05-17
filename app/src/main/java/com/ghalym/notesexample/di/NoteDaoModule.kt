package com.ghalym.notesexample.di

import android.app.Application
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.notesexample.model.NoteDao
import com.ghalym.notesexample.model.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Singleton
    @Provides
    fun getNoteDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.noteDao()
    }

}
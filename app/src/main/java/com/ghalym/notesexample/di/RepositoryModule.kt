package com.ghalym.notesexample.di

import android.app.Application
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.notesexample.MyApp
import com.ghalym.notesexample.model.NoteDao
import com.ghalym.notesexample.model.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule() {
    @Provides
    fun getRepostory(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }


}
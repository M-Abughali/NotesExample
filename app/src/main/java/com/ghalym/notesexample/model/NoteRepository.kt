package com.ghalym.notesexample.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import javax.inject.Inject

class NoteRepository @Inject constructor(val noteDao: NoteDao) {

    fun getNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    fun insertNote(note: Note): Long = noteDao.addNote(note)

    fun deleteNote(note: Note): Int = noteDao.deleteNote(note)

    fun updateNote(note: Note): Int = noteDao.updateNote(note)


}
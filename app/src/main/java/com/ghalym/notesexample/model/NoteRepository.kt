package com.ghalym.notesexample.model

import androidx.lifecycle.LiveData

class NoteRepository(val noteDao: NoteDao) {

    suspend fun getNotes(): LiveData<List<Note>> = noteDao.getAllNotes()
    
    suspend fun insertNote(note: Note): Int = noteDao.addNote(note)

    suspend fun deleteNote(note: Note): Long = noteDao.deleteNote(note)

    suspend fun updateNote(note: Note): Long = noteDao.updateNote(note)


}
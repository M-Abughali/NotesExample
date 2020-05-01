package com.ghalym.notesexample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
     fun addNote(note: Note): Long

    @Query("select * from note")
     fun getAllNotes(): LiveData<List<Note>>

    @Delete
     fun deleteNote(note: Note): Int

    @Update
     fun updateNote(note: Note): Int


}
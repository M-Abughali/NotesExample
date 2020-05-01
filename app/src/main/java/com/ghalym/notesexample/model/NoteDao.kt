package com.ghalym.notesexample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note): Int

    @Query("select * from note")
    suspend fun getAllNotes(): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note): Long

    @Update
    suspend fun updateNote(note: Note): Long


}
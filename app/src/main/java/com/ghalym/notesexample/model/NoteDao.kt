package com.ghalym.notesexample.model

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note): Int

    @Query("select * from note")
    suspend fun getAllNotes(): List<Note>

    @Delete
    suspend fun deleteNote(note: Note): Long

    @Update
    suspend fun UpdateNote(note: Note): Long


}
package com.ghalym.notesexample.model

import androidx.lifecycle.LiveData
import javax.inject.Inject
import com.ghalym.notesexample.util.*;
import java.lang.Exception

class NoteRepository @Inject constructor(val noteDao: NoteDao) {


    companion object {
        val INSERT_SUCCESS_MESSAGE = "INSERT_SUCCESS_MESSAGE";
        val INSERT_FAIL_MESSAGE = "INSERT_FAIL_MESSAGE";
        val INSERT_INVALIDE_DATA = "INSERT_INVALIDE_DATA";

    }


    fun getNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    fun insertNote(note: Note): Result<Long> {

        if (note.isValid()) {
            val insertResult: Long = noteDao.addNote(note);
            if (insertResult > 0) {
                return Result.Success(insertResult, INSERT_SUCCESS_MESSAGE)
            } else {
                return Result.Error(INSERT_FAIL_MESSAGE)
            }
        } else {
            throw Exception(INSERT_INVALIDE_DATA);
        }
    }

    fun deleteNote(note: Note): Int = noteDao.deleteNote(note)

    fun updateNote(note: Note): Int = noteDao.updateNote(note)


}
package com.ghalym.notesexample.model

import android.app.Application
import com.ghalym.notesexample.R
import com.ghalym.notesexample.model.NoteRepository.Companion.INSERT_FAIL_MESSAGE
import com.ghalym.notesexample.model.NoteRepository.Companion.INSERT_SUCCESS_MESSAGE
import com.ghalym.notesexample.util.Result
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.mockito.Mockito
import org.mockito.Mockito.*
import java.lang.Exception
import java.util.concurrent.Executor

@RunWith(MockitoJUnitRunner::class)
class NoteRepositoryTest {

    @Mock
    lateinit var noteDao: NoteDao;

    @Mock
    lateinit var noteRepository: NoteRepository


    @Before
    fun setup() {
        noteRepository = NoteRepository(noteDao);
    }

    @Test
    fun NoteDao_SUTnotNull_trueReturend() {
        assertNotNull(noteDao)
    }

    @Test
    fun NoteRepository_SUTnotNull_trueReturend() {
        assertNotNull(noteRepository)
    }


    // test insert note with complete values =>Success
    // test insert note failure =>Error Result

    // test insert note without title =>Error Result
    // test insert note without content =>Error Result

    @Test
    fun insert_successReturend() {
        // Arrange
        `when`(noteDao.addNote(any())).thenReturn(1);
        //  Act
        val result =
            noteRepository.insertNote(Note(title = "title", content = "content"))
        //Assert
        assertEquals(Result.Success<Long>(1, INSERT_SUCCESS_MESSAGE), result);
    }


    @Test
    fun insert_failReturend() {
        // Arrange
        `when`(noteDao.addNote(any())).thenReturn(0);
        //  Act
        val result =
            noteRepository.insertNote(Note(title = "title", content = "content"))
        //Assert
        assertEquals(Result.Error(INSERT_FAIL_MESSAGE), result);
    }







    fun <T> any(): T = Mockito.any<T>()

}
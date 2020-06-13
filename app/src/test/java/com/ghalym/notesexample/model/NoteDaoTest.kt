package com.ghalym.notesexample.model

import com.ghalym.notesexample.util.Result
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.BeforeClass
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner::class)
class NoteDaoTest {

    @Mock
    lateinit var noteDao: NoteDao;

    @Test
    fun NoteDao_SUTnotNull_trueReturend() {
        assertNotNull(noteDao)
    }


    // test insert note with complete values =>Success
    // test insert note without title =>Error Result
    // test insert note without content =>Error Result
    // test insert note failure =>Error Result

    @Test

    fun insertNoteUsinDao_successReturend() {

        `when`(noteDao.addNote(any())).thenReturn(1);
        val result = noteDao.addNote(Note(title = "title", content = "content"));
        assertEquals(result, 1);

    }







    fun <T> any(): T = Mockito.any<T>()

}
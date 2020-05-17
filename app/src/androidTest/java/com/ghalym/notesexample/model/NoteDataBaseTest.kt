package com.ghalym.notesexample.model

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After

class NoteDataBaseTest {

    lateinit var SUT: NoteDataBase

    fun getNoteDao(): NoteDao {
        return SUT.noteDao();
    }

    @Before
    fun setup() {
        SUT = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDataBase::class.java
        ).build()

    }


    

    @After
    fun teardown() {
        SUT.close()
    }
}
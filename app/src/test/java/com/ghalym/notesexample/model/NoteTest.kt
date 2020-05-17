package com.ghalym.notesexample.model

import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class NoteTest {
    // compare 2 Notes equal =>return true
    // compare 2 Notes with different id => return false
    // compare 2 Notes with different title => return false
    // compare 2 Notes with different content => return false
    // check is Note valid information =>true
    // check is Note with empty Note title=>false
    // check is Note with empty content=>false


    val ID1: Long = 1;
    val TITLE1: String = "TITLE1";
    val CONTENT1: String = "CONTENT1";


    val ID2: Long = 2;
    val TITLE2: String = "TITLE2";
    val CONTENT2: String = "CONTENT2";


    @Test
    fun isEqual_2EqualNotes_returnTrue() {
        //Arrange
        val note1 = Note(ID1, TITLE1, CONTENT1);
        val note2 = Note(ID1, TITLE1, CONTENT1);
        //Act
        val result = note1.isEqual(note2);
        //Asset
        assertThat(result, `is`(true))
    }


    @Test
    fun isEqual_2NotesWithDifferentId_returnFalse() {
        //Arrange
        val note1 = Note(ID1, TITLE1, CONTENT1);
        val note2 = Note(ID2, TITLE1, CONTENT1);
        //Act
        val result = note1.isEqual(note2);
        //Asset
        assertThat(result, `is`(false))
    }


    @Test
    fun `isEqual_2NotesWithDifferentTITLE_returnFalse`() {
        //Arrange
        val note1 = Note(ID1, TITLE1, CONTENT1);
        val note2 = Note(ID1, TITLE2, CONTENT1);
        //Act
        val result = note1.isEqual(note2);
        //Asset
        assertThat(result, `is`(false))
    }


    @Test
    fun isEqual_2NotesWithDifferentPassword_returnFalse() {
        //Arrange
        val note1 = Note(ID1, TITLE1, CONTENT1);
        val note2 = Note(ID1, TITLE1, CONTENT2);
        //Act
        val result = note1.isEqual(note2);
        //Asset
        assertThat(result, `is`(false))
    }



    @Test
    fun isValid_validNoteInfo_returnTrue() {
        //Arrange
        val Note = Note(ID1, TITLE1, CONTENT1);
        //Act
        val result = Note.isValid();
        //Asset
        assertThat(result, `is`(true))
    }

    @Test
    fun isValid_EmptyNoteTITLE_returnFalse() {
        //Arrange
        val Note = Note(ID1, "", CONTENT1);
        //Act
        val result = Note.isValid();
        //Asset
        assertThat(result, `is`(false))
    }

    @Test
    fun isValid_EmptyPassword_returnFalse() {
        //Arrange
        val Note = Note(ID1, TITLE1, "");
        //Act
        val result = Note.isValid();
        //Asset
        assertThat(result, `is`(false))
    }
}
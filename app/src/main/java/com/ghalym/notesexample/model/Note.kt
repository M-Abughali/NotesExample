package com.ghalym.notesexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Note")
data class Note(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String
)
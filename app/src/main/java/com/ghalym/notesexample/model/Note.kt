package com.ghalym.notesexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Note")
data class Note(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String
) : Serializable,INote{

    override fun isEqual(iNote: INote): Boolean {
        iNote as Note
        return iNote.id == id && iNote.title == title && iNote.content == content;
    }

    override fun isValid(): Boolean {
        return !title.isEmpty() && !content.isEmpty()
    }

}

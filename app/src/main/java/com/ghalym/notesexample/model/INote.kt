package com.ghalym.notesexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


interface INote {
    fun isEqual(iNote: INote): Boolean
    fun isValid(): Boolean
}
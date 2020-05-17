package com.ghalym.databasesexample.roomExample.Note.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteDao


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase(){
    companion object{
       final val DATABASE_NAME="DATABASE_NAME"
    }
    abstract fun noteDao(): NoteDao

//    companion object {
//        @Volatile private var instance: NoteDataBase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also { instance = it}
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
//            NoteDataBase::class.java, "note-list.db")
//            .build()
//    }
}



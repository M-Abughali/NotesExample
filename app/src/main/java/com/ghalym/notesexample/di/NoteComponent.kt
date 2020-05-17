package com.ghalym.notesexample.di

import com.ghalym.notesexample.ui.AddAndUpdateNoteFragment
import com.ghalym.notesexample.ui.displayNotes.DisplayAndDeleteNotesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NoteDaoModule::class, NoteDataBaseModule::class, RepositoryModule::class])
interface NoteComponent {

    fun inject(addAndUpdateNoteFragment: AddAndUpdateNoteFragment)
    fun inject(displayAndDeleteNotesFragment: DisplayAndDeleteNotesFragment)


}
package com.ghalym.notesexample.di

import com.ghalym.notesexample.ui.AddAndUpdateNoteFragment
import com.ghalym.notesexample.ui.displayNotes.DisplayAndDeleteNotesFragment
import dagger.Component


@Component
interface NoteComponent {

    fun inject(addAndUpdateNoteFragment: AddAndUpdateNoteFragment)
    fun inject(displayAndDeleteNotesFragment: DisplayAndDeleteNotesFragment)


}
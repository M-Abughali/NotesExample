package com.ghalym.notesexample.ui.displayNotes

import com.ghalym.notesexample.model.Note

interface OnShowOptionMenu {
    fun onShowOptionMenu(note: Note,position:Int);
}
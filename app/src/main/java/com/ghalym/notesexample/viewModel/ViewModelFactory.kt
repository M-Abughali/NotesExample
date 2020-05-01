package com.ghalym.notesexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ghalym.notesexample.model.NoteRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(val noteRepository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InsertViewModel::class.java)) {
            return InsertViewModel(repository = noteRepository) as T
        }
        throw IllegalArgumentException("error from factory")
    }

}
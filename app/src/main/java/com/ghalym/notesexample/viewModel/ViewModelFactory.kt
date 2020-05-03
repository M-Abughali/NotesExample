package com.ghalym.notesexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ghalym.notesexample.model.NoteRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(val noteRepository: NoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InsertViewModel::class.java)) {
            return InsertViewModel(repository = noteRepository) as T
        } else if (modelClass.isAssignableFrom(DisplayViewModel::class.java)) {
            return DisplayViewModel(repository = noteRepository) as T
        }
        throw IllegalArgumentException("error from factory")
    }

}
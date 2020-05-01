package com.ghalym.notesexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisplayViewModel(val repository: NoteRepository) : ViewModel() {

    val notesLiveData = repository.getNotes()
    val deleteLiveData = MutableLiveData<String>()
    fun deleteNote(note: Note) {

        CoroutineScope(IO).launch {

            val result = repository.deleteNote(note)

            withContext(Main) {
                if (result > 0) {
                    deleteLiveData.value = "Delete Note Success"
                } else {
                    deleteLiveData.value = "Something error when delete"

                }
            }
        }

    }


}
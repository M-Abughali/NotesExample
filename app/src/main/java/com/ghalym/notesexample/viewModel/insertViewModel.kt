package com.ghalym.notesexample.viewModel

import android.text.TextUtils
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteDao
import com.ghalym.notesexample.model.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class insertViewModel(val repository: NoteRepository) : ViewModel() {
    val insertResultLiveData = MutableLiveData<String>();

    @Bindable
    var titleLiveData = MutableLiveData<String>();

    @Bindable
    var contentLiveData = MutableLiveData<String>();

    fun insertNewNote() {

        when {
            TextUtils.isEmpty(titleLiveData.value) -> {
                insertResultLiveData.value = "Error in Title"
            }
            TextUtils.isEmpty(contentLiveData.value) -> {
                insertResultLiveData.value = "Error in Content"
            }
            else -> {

                CoroutineScope(IO).launch {
                    repository.insertNote(
                        Note(
                            title = titleLiveData.value!!,
                            content = contentLiveData.value!!
                        )
                    )
                }

            }


        }


    }


}
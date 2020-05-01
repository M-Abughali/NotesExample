package com.ghalym.notesexample.viewModel

import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteDao
import com.ghalym.notesexample.model.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InsertViewModel(val repository: NoteRepository) : ViewModel(), Observable {
    val insertResultLiveData = MutableLiveData<String>()
    val updateLiveData = MutableLiveData<String>()

    @Bindable
    var btnLiveData = MutableLiveData<String>()

    @Bindable
    var idLiveData = MutableLiveData<Long>()

    @Bindable
    var titleLiveData = MutableLiveData<String>()

    @Bindable
    var contentLiveData = MutableLiveData<String>()

    fun insertNewNote() {
        insertResultLiveData.value = ""
        when {
            TextUtils.isEmpty(titleLiveData.value) -> {
                insertResultLiveData.value = "Error in Title"
            }
            TextUtils.isEmpty(contentLiveData.value) -> {
                insertResultLiveData.value = "Error in Content"

            }
            else -> {

                CoroutineScope(IO).launch {

                    if (idLiveData.value != null) {

                        updateNote(
                            Note(
                                id = idLiveData.value!!,
                                title = titleLiveData.value!!,
                                content = contentLiveData.value!!
                            )
                        )
                    } else {

                        insertNote(
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

    suspend fun insertNote(note: Note) {
        val result = repository.insertNote(note)
        withContext(Main) {
            if (result.toInt() != -1) {
                insertResultLiveData.value = "Added Successfult"
                titleLiveData.value = ""
                contentLiveData.value = ""
            } else {
                insertResultLiveData.value = "Error in inserting"
            }
        }
    }

    suspend fun updateNote(note: Note) {
        val result = repository.updateNote(note)
        withContext(Main) {

            if (result > 0) {
                updateLiveData.value = "update Note Success"
            } else {
                updateLiveData.value = "Something error when update"

            }
        }

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}
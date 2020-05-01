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
                    val result = repository.insertNote(
                        Note(
                            title = titleLiveData.value!!,
                            content = contentLiveData.value!!
                        )
                    )
                    withContext(Main){
                        if (result.toInt() != -1) {
                            insertResultLiveData.value = "Added Successfult"
                            titleLiveData.value = ""
                            contentLiveData.value = ""
                        } else {
                            insertResultLiveData.value = "Error in inserting"
                        }
                    }


                }

            }


        }


    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}
package com.ghalym.notesexample.util

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T,val msg:String) : Result<T>()
    data class Error(val msg:String) : Result<Nothing>()
    object InProgress : Result<Nothing>()
}

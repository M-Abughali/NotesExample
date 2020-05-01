package com.ghalym.notesexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.notesexample.R
import com.ghalym.notesexample.databinding.FragmentAddNoteBinding
import com.ghalym.notesexample.model.NoteRepository
import com.ghalym.notesexample.viewModel.InsertViewModel
import com.ghalym.notesexample.viewModel.ViewModelFactory



class AddNoteFragment : Fragment() {
    lateinit var fragmentAddNoteBinding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAddNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)


        val noteDao =
            NoteDataBase.invoke(requireActivity().applicationContext).noteDao()
        val noteRepository = NoteRepository(noteDao)
        val viewModelFactory = ViewModelFactory(noteRepository)


        val insertViewModelInsertViewModel =
            ViewModelProvider(this, viewModelFactory).get(InsertViewModel::class.java)

        fragmentAddNoteBinding.lifecycleOwner = this
        fragmentAddNoteBinding.model = insertViewModelInsertViewModel


        return fragmentAddNoteBinding.root

    }

}

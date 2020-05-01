package com.ghalym.notesexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.notesexample.R
import com.ghalym.notesexample.databinding.FragmentAddUpdateNoteBinding
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteRepository
import com.ghalym.notesexample.viewModel.InsertViewModel
import com.ghalym.notesexample.viewModel.ViewModelFactory


class AddAndUpdateNoteFragment : Fragment() {
    lateinit var fragmentAddUpdateNoteBinding: FragmentAddUpdateNoteBinding
    lateinit var insertViewModel: InsertViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAddUpdateNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_update_note, container, false)


        val noteDao =
            NoteDataBase.invoke(requireActivity().applicationContext).noteDao()
        val noteRepository = NoteRepository(noteDao)
        val viewModelFactory = ViewModelFactory(noteRepository)


        insertViewModel =
            ViewModelProvider(this, viewModelFactory).get(InsertViewModel::class.java)
        val note: Note? =
            if (arguments?.containsKey("note") == true) arguments?.getSerializable("note") as Note else null

        if (note != null) {
            insertViewModel.btnLiveData.value = getString(R.string.update_note)
            insertViewModel.idLiveData.value = note.id
            insertViewModel.titleLiveData.value = note.title
            insertViewModel.contentLiveData.value = note.content
        } else {
            insertViewModel.btnLiveData.value = getString(R.string.add_note)

        }

        fragmentAddUpdateNoteBinding.lifecycleOwner = this
        fragmentAddUpdateNoteBinding.model = insertViewModel


        setupUpdateLiveData()
        return fragmentAddUpdateNoteBinding.root

    }


    fun setupUpdateLiveData() {
        insertViewModel.updateLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            requireActivity().onBackPressed()

        })
    }

}

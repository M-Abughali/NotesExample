package com.ghalym.notesexample.ui.displayNotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghalym.databasesexample.roomExample.Note.data.NoteDataBase
import com.ghalym.notesexample.MyApp
import com.ghalym.notesexample.R
import com.ghalym.notesexample.databinding.FragmentDisplayNotesBinding
import com.ghalym.notesexample.model.Note
import com.ghalym.notesexample.model.NoteRepository
import com.ghalym.notesexample.viewModel.DisplayViewModel
import com.ghalym.notesexample.viewModel.InsertViewModel
import com.ghalym.notesexample.viewModel.ViewModelFactory
import java.nio.file.Files.delete
import javax.inject.Inject

class DisplayAndDeleteNotesFragment : Fragment(), OnShowOptionMenu {
    private val notesList = ArrayList<Note>()
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var displayViewModel: DisplayViewModel
    private lateinit var fragmentDisplayNotesBinding: FragmentDisplayNotesBinding

    @Inject
    lateinit var viewModelFactory:ViewModelFactory;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDisplayNotesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_display_notes, container, false)

        MyApp.getInstance().getNoteComponent().inject(this);

        displayViewModel =
            ViewModelProvider(this, viewModelFactory).get(DisplayViewModel::class.java)


        notesAdapter = NotesAdapter(notesList, this)
        fragmentDisplayNotesBinding.apply {
            rvNotes.adapter = notesAdapter
            rvNotes.layoutManager = LinearLayoutManager(requireActivity())

        }


        setupDisplayLiveData()
        setupDeleteLiveData()

        return fragmentDisplayNotesBinding.root

    }

    fun setupDisplayLiveData() {

        displayViewModel.notesLiveData.observe(viewLifecycleOwner, Observer {
            notesList.clear()
            notesList.addAll(it)
            notesAdapter.notifyDataSetChanged()
        })
    }

    fun setupDeleteLiveData() {
        displayViewModel.deleteLiveData.observe(viewLifecycleOwner, Observer {

            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()

        })
    }


    override fun onShowOptionMenu(note: Note, position: Int) {
        val menu =
            PopupMenu(requireActivity(), fragmentDisplayNotesBinding.rvNotes.getChildAt(position))
        menu.inflate(R.menu.notes_menu)
        menu.show()
        menu.setOnMenuItemClickListener {


            when (it.itemId) {
                R.id.menuItemDelete -> {
                    displayViewModel.deleteNote(note)
                }
                R.id.menuItemUpdate -> {
                    val bundle = Bundle()
                    bundle.putSerializable("note", note)
                    Navigation.findNavController(fragmentDisplayNotesBinding.root)
                        .navigate(R.id.action_displayFragment_to_addNoteFragment, bundle)
                }

            }


            return@setOnMenuItemClickListener true
        }
    }
}

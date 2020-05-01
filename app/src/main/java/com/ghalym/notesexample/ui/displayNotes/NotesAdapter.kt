package com.ghalym.notesexample.ui.displayNotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.ghalym.notesexample.R
import com.ghalym.notesexample.databinding.RowNoteBinding
import com.ghalym.notesexample.model.Note

class NotesAdapter(val list: List<Note>, val onShowOptionMenu: OnShowOptionMenu) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);
        val rowNoteBinding: RowNoteBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.row_note, parent, false);

        return NoteViewHolder(rowNoteBinding);

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class NoteViewHolder(val rowNoteBinding: RowNoteBinding) :
        RecyclerView.ViewHolder(rowNoteBinding.root) {

        fun bind(note: Note) {
            rowNoteBinding.note = note
            rowNoteBinding.imgMenu.setOnClickListener {
                onShowOptionMenu.onShowOptionMenu(note,adapterPosition)

            }
        }
    }

}
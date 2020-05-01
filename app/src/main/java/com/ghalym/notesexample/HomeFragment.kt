package com.ghalym.notesexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ghalym.notesexample.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        fragmentHomeBinding.apply {

            moveToAddNote.setOnClickListener {

                Navigation.findNavController(moveToAddNote)
                    .navigate(R.id.action_homeFragment_to_addNoteFragment)


            }


        }


        return fragmentHomeBinding.root
    }

}

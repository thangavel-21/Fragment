package com.terareum.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.terareum.fragments.databinding.NotesFragmentBinding

class NotesFragment : Fragment() {
    private lateinit var binding: NotesFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NotesFragmentBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // get detail via bundle by using arguments
        if (arguments != null) Toast.makeText(context, arguments?.getString("key1"), Toast.LENGTH_LONG).show()
    }
}
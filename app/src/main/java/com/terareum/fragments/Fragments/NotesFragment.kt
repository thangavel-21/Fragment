package com.terareum.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.terareum.fragments.Adapters.NotesAdapter
import com.terareum.fragments.Database.AddNotesDataClass
import com.terareum.fragments.R
import com.terareum.fragments.ViewModel.NotesViewModel
import com.terareum.fragments.databinding.NotesFragmentBinding
import java.time.LocalDateTime
import java.util.*

class NotesFragment : Fragment() {
    private lateinit var binding: NotesFragmentBinding
    private lateinit var viewModel: NotesViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NotesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = context?.let { NotesViewModel(it) }!!
        init()
        binding.notesRecyclerview.layoutManager = LinearLayoutManager(context)
        viewModel.getAllNote.observe(viewLifecycleOwner) { notesList ->
            binding.notesRecyclerview.adapter = NotesAdapter(requireContext() , notesList)

        }
        binding.floatingBtn.setOnClickListener {}
    }

    private fun getDate(): String {
        val dateTime = LocalDateTime.now()
        val month = dateTime.month              // current month
        val date = dateTime.dayOfMonth          // current date
        val date1 = requireContext().getString(R.string.time_format , month, date)
        date1.substring(0,1).uppercase(Locale.ROOT) + date1.substring(1).toLowerCase()
        return  date1
    }

    private fun init() {
        val note = AddNotesDataClass(0, "sample", "some text",getDate())
        viewModel.addNotes(note)
    }
}
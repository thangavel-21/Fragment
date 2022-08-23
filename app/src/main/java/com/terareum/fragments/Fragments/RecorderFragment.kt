package com.terareum.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.terareum.fragments.R
import com.terareum.fragments.databinding.RecorderFragmentBinding

class RecorderFragment : Fragment() {
    private lateinit var binding: RecorderFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecorderFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.click.setOnClickListener {
         val bundle = Bundle()
            bundle.putString("key1","check")
            val frag = NotesFragment()
            frag.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.frame_layout, frag).commit()
        }
    }
}
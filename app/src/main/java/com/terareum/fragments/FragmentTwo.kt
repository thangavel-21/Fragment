package com.terareum.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.terareum.fragments.databinding.FragmentOneBinding
import com.terareum.fragments.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.click.setOnClickListener {
         val bundle = Bundle()
            bundle.putString("key1","check")
            val frag = FragmentOne()
            frag.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.frame_layout, frag).commit()
        }
    }
}
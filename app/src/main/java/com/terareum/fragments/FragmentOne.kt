package com.terareum.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.terareum.fragments.databinding.FragmentOneBinding
import kotlin.math.log

class FragmentOne : Fragment() {
    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadShimmer()
        // get detail via bundle by using arguments
        if (arguments != null) Toast.makeText(context, arguments?.getString("key1"), Toast.LENGTH_LONG).show()
        binding.click.setOnClickListener {
            val intent = Intent(context, SampleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadShimmer() {
        binding.shimmerLayout.startShimmer()
        Handler(Looper.getMainLooper()).postDelayed({
            binding.shimmerLayout.stopShimmer()
            binding.shimmerLayout.visibility = View.GONE
        },3000)
    }
}
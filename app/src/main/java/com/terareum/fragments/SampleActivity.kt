package com.terareum.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.terareum.fragments.databinding.SampleActivityBinding

class SampleActivity: AppCompatActivity() {
   private lateinit var binding: SampleActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SampleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.terareum.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.terareum.fragments.Fragments.NotesFragment
import com.terareum.fragments.Fragments.RecorderFragment
import com.terareum.fragments.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomTabNavigation()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, NotesFragment()).commit()
    }

    private fun bottomTabNavigation() {
        if (false) {
            binding.bottomNav.inflateMenu(R.menu.rtl_bottomtab)
            binding.bottomNav.selectedItemId = R.id.action_home
        } else {
            binding.bottomNav.inflateMenu(R.menu.bottom_tab_navigation)
        }
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    replace(NotesFragment())
                    true
                }
                R.id.action_more -> {
                    replace(RecorderFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun replace(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}
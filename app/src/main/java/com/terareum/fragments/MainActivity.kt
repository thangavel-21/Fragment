package com.terareum.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.terareum.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomTabNavigation()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentOne()).commit()
    }

    private fun bottomTabNavigation() {
        binding.bottomNav.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.action_home -> {
                    replace(FragmentOne())
                    true
                }
                R.id.action_more -> {
                    replace(FragmentTwo())
                    true
                }
                else -> {true}
            }
        }
    }

    private fun replace(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }
}
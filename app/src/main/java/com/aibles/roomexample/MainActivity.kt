package com.aibles.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aibles.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = EmailAdapter(this)
        binding.recyclerEmail.adapter = adapter
    }
}
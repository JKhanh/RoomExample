package com.aibles.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.aibles.roomexample.databinding.ActivityMainBinding
import com.aibles.roomexample.entity.Email
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel: EmailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = EmailViewModel(application)

        val adapter = EmailAdapter(this)
        binding.recyclerEmail.adapter = adapter

        viewModel.getEmail().observe(this){
            if(it != null){
                for (email in it) {
                    adapter.emailList.add(email)
                }
                adapter.notifyDataSetChanged()
            }
        }

        binding.buttonAddEmail.setOnClickListener {
            viewModel.addEmail()
        }

    }
}
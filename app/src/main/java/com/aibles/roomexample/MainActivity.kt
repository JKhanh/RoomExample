package com.aibles.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aibles.roomexample.databinding.ActivityMainBinding
import com.aibles.roomexample.entity.Email
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var repository: EmailRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = EmailAdapter(this)
        binding.recyclerEmail.adapter = adapter

        repository = EmailRepository(application)
        repository.getAllEmail().observe(this){
            if(it != null){
                for (email in it) {
                    adapter.emailList.add(email)
                }
                adapter.notifyDataSetChanged()
            }
        }

        binding.buttonAddEmail.setOnClickListener {
            val email = Email("Tu Room", "Android")
            CoroutineScope(Dispatchers.IO).launch {
                repository.insertEmail(email)
            }
        }

    }
}
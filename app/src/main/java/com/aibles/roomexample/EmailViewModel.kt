package com.aibles.roomexample

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aibles.roomexample.entity.Email
import kotlinx.coroutines.*
import timber.log.Timber

class EmailViewModel(application: Application): ViewModel() {
    private val repository: EmailRepository = EmailRepository(application)

    var emailList: LiveData<List<Email>> = MutableLiveData()

    fun addEmail(){
        viewModelScope.launch(Dispatchers.IO){
            val email = Email("Tu Room", "Android")
            repository.insertEmail(email)
        }
    }

//    fun getEmail(){
//        viewModelScope.launch(Dispatchers.IO){
//            withContext(Dispatchers.Main) {
//                Timber.d("getEmail: ")
//                emailList = repository.getAllEmail()
//            }
//        }
//    }

    fun getEmail() =
        repository.getAllEmail()
}
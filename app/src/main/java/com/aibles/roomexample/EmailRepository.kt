package com.aibles.roomexample

import android.app.Application
import com.aibles.roomexample.entity.Email
import com.aibles.roomexample.local.EmailDatabase

class EmailRepository(application: Application) {
    val database = EmailDatabase.getInstance(application)

    fun insertEmail(email: Email){
        database.emailDao().addEmail(email)
    }

    fun getAllEmail() = database.emailDao().getAllEmail()
}
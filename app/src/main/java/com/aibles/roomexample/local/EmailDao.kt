package com.aibles.roomexample.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aibles.roomexample.entity.Email

@Dao
interface EmailDao {
    @Insert
    fun addEmail(email: Email)

    @Insert
    fun addEmail(emails: List<Email>)

    @Update
    fun updateEmail(email: Email)

    @Delete
    fun deleteEmail(email: Email)

    @Query("SELECT * FROM email")
    fun getAllEmail(): LiveData<List<Email>>
}
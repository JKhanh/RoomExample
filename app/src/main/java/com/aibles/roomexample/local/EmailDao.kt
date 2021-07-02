package com.aibles.roomexample.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aibles.roomexample.entity.Email

@Dao
interface EmailDao {
    @Insert
    suspend fun addEmail(email: Email)

    @Insert
    suspend fun addEmail(emails: List<Email>)

    @Update
    suspend fun updateEmail(email: Email)

    @Delete
    suspend fun deleteEmail(email: Email)

    @Query("SELECT * FROM email")
    fun getAllEmail(): LiveData<List<Email>>
}
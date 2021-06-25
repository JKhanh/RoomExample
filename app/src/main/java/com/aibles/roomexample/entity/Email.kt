package com.aibles.roomexample.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Email(
    val receiver: String,
    val content: String,
    @PrimaryKey(autoGenerate = true) var id: Long = 0)

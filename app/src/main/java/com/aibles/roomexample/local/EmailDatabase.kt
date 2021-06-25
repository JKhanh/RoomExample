package com.aibles.roomexample.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aibles.roomexample.entity.Email

@Database(
    entities = [Email::class],
    version = 1,
    exportSchema = false
)
abstract class EmailDatabase: RoomDatabase() {
    abstract fun emailDao(): EmailDao

    companion object{
        @Volatile
        private var INSTANCE: EmailDatabase? = null

        fun getInstance(context: Context): EmailDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    EmailDatabase::class.java, "color_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
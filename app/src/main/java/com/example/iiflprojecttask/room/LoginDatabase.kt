package com.example.iiflprojecttask.room
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.iiflprojecttask.models.DataList

@Database(entities = arrayOf(DataList::class), version = 2, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: LoginDatabase? = null

        fun getDataseClient(context: Context) : LoginDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, LoginDatabase::class.java, "iifl_database.db")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}
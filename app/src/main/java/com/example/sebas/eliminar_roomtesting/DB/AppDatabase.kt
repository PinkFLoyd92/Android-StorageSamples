package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User

/**
 * Created by sebas on 1/18/18.
 */

@Database(entities = arrayOf(User::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "testDB").build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}


package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User

/**
 * Created by sebas on 1/18/18.
 */

@Database(entities = arrayOf(User::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}


package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by sebas on 1/18/18.
 */

@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesAppContext() = context

    @Provides fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "testDB").allowMainThreadQueries().build()

    @Provides fun providesUserDAO(database: AppDatabase) = database.userDao()
}
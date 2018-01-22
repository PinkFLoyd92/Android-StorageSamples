package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.arch.persistence.room.migration.Migration
import android.content.Context
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User
import com.example.sebas.eliminar_roomtesting.DB.type_converters.DateConverter

/**
 * Created by sebas on 1/18/18.
 */

@Database(entities = arrayOf(User::class), version = 3, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var MIGRATION_2_3 : Migration = object:Migration(2,3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN birth_date TEXT");
            }
        }

        private var MIGRATION_1_2 : Migration = object:Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN age INT");
            }
        }

        private var MIGRATION_1_3 : Migration = object:Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN birth_date TEXT");
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN age INT");
            }
        }

        private var INSTANCE : AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "testDB")
                        .allowMainThreadQueries() // remove this!!!!
                        .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_1_3)
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
    }


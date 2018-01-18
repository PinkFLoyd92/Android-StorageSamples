package com.example.sebas.eliminar_roomtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.sebas.eliminar_roomtesting.DB.AppDatabase
import com.example.sebas.eliminar_roomtesting.DB.AppModule
import com.example.sebas.eliminar_roomtesting.DB.Model.User
import com.example.sebas.eliminar_roomtesting.DB.UserSeeder

class MainActivity : AppCompatActivity() {
    // open var appDB : AppModule? = null
    // open var appDatabase : AppDatabase? = null
    open var db : AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // appDB = AppModule(this)
        //appDatabase = appDB?.providesAppDatabase(this)
        db = AppDatabase.getAppDatabase(this)
        UserSeeder.seed(db.userDao())
        
        Log.d("COUNT", db.userDao().countUsers().toString())
        Log.d("MALE GENDER ", db.userDao().getUsersByGender("male").toString())
        Log.d("FEMALE GENDER ", db.userDao().getUsersByGender("female").toString())
        Log.d("OTHER GENDER ", db.userDao().getUsersByGender("").toString())
        Log.d("OTHER FILTER...", db.userDao().getUsersByName("sebas").toString())

    }

    fun create_user(view : View){
        // Log.d("COUNT", appDB?.providesUserDAO(appDatabase as AppDatabase)?.countUsers().toString())
        Log.d("SUBMIT", "Creating user")
    }
}

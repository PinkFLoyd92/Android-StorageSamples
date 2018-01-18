package com.example.sebas.eliminar_roomtesting

import android.os.AsyncTask
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
        UserSeeder.seed(db!!.userDao())

        val query_gender1 = AsyncQueryGetUsersByGender(db!!)
        query_gender1.execute("male")

        val query_gender2 = AsyncQueryGetUsersByGender(db!!)
        query_gender2.execute("female")

        val query_gender3 = AsyncQueryGetUsersByGender(db!!)
        query_gender3.execute("")

        val query_name1 = AsyncQueryGetUsersByName(db!!)
        query_name1.execute("sebas")
    }

    fun create_user(view : View){
        // Log.d("COUNT", appDB?.providesUserDAO(appDatabase as AppDatabase)?.countUsers().toString())
        Log.d("SUBMIT", "Creating user")
    }




    inner class AsyncQueryGetUsersByGender : AsyncTask<String, String, List<User>> {
        var database : AppDatabase? = null

        constructor(database: AppDatabase) {
            this.database = database
        }

        override fun doInBackground(vararg p0: String?): List<User> {
            Log.d("ASYNC TASK: ", p0[0].toString())
           return db?.userDao()?.getUsersByGender(p0[0] as String) as List<User>
        }

        override fun onPostExecute(result: List<User>?) {
            Log.d("USERS BY GENDER", result.toString())
        }
    }

    inner class AsyncQueryGetUsersByName : AsyncTask<String, String, List<User>> {
        var database : AppDatabase? = null

        constructor(database: AppDatabase) {
            this.database = database
        }

        override fun doInBackground(vararg p0: String?): List<User> {
            Log.d("ASYNC TASK 2: ", p0[0].toString())
            return db?.userDao()?.getUsersByName(p0[0] as String) as List<User>
        }

        override fun onPostExecute(result: List<User>?) {
            Log.d("ASYNCTASK2-UsersByName:", result.toString())
        }
    }
}

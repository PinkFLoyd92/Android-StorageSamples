package com.example.sebas.eliminar_roomtesting

import android.database.Cursor
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.sebas.eliminar_roomtesting.DB.AppDatabase
import com.example.sebas.eliminar_roomtesting.DB.Model.User
import com.example.sebas.eliminar_roomtesting.DB.UserSeeder

class MainActivity : AppCompatActivity() {
    open var db : AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase.getAppDatabase(this.applicationContext)
        UserSeeder.seed(db!!.userDao())

/*
        val query_genderMale = AsyncQueryCountUsersGender(db!!)
        query_genderMale.execute("male")
        val query_genderFemale = AsyncQueryCountUsersGender(db!!)
        query_genderFemale.execute("female")

        val query_genderOther = AsyncQueryCountUsersGender(db!!)
        query_genderOther.execute("non-binary")
*/

        val query_name1 = AsyncQueryGetUsersByName(db!!)
        query_name1.execute("sebas")

        val query_groupbySex1 = AsyncQueryGroupBySex(db!!)
        query_groupbySex1.execute()
    }

    fun create_user(view : View){
        // Log.d("COUNT", appDB?.providesUserDAO(appDatabase as AppDatabase)?.countUsers().toString())
        Log.d("SUBMIT", "Creating user")
    }


    inner class AsyncQueryGroupBySex:AsyncTask<String, String, Cursor> {
        var database : AppDatabase? = null

        constructor(database: AppDatabase) {
            this.database = database
        }

        override fun doInBackground(vararg p0: String?): Cursor {
            return db?.userDao()?.getGroupedUsers() as Cursor
        }

        override fun onPostExecute(result: Cursor?) {
            try {
                if(result!!.moveToFirst()){
                    while (result != null) {
                        // do what you need with the cursor here
                        Log.d("SEX TASK", result!!.getInt(result!!.getColumnIndex("count(sex)")).toString()
/*                                + " NAME: "
                                + result!!.getString(result!!.getColumnIndex("first_name"))*/
                                + " SEXO: "
                                + result!!.getString(result!!.getColumnIndex("sex"))
                                + " BIRTHDAY: "
                                + result!!.getString(result!!.getColumnIndex("birth_date"))
                        )
                        // Log.d("SEX name", result!!.getString(result!!.getColumnIndex("first_name")))
                        result!!.moveToNext()
                    }
                }
            } catch(e: Exception) {
                Log.d("excepcion..", e.message)
            }
        }
    }

    inner class AsyncQueryCountUsersGender:AsyncTask<String, String, Int> {
        var database : AppDatabase? = null

        constructor(database: AppDatabase) {
            this.database = database
        }

        override fun doInBackground(vararg p0: String?): Int {
            Log.d("ASYNC TASK GENDER: ", p0[0].toString())
            return db?.userDao()?.countUsersByGender(p0[0] as String) as Int
        }

        override fun onPostExecute(result: Int?) {
            Log.d("GENDER: ", result.toString())
        }
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

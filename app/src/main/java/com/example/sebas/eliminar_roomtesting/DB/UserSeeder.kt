package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.RoomDatabase
import android.util.Log
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by sebas on 1/18/18.
 */

public class UserSeeder {
    companion object {
        var listUsers : List<User> = mutableListOf<User>()
        fun seed(userDao: UserDao){
            var sdf : SimpleDateFormat? = SimpleDateFormat( "yyyy-MM-dd")
            listUsers = userDao.getAll()
            Log.d("SEEDER - USERS", listUsers.size.toString())
            delete(userDao)
            listUsers = mutableListOf<User>()
            for (a in 1..10){
                val user : User = User()
                user.setAge(10)
                if(a%2 == 0) { // sex male
                    user.setFirstName("Sebas")
                    user.setLastName("Caceres")
                    user.setSex("male")
                    user.setBirthday(sdf!!.parse("1992-05-15"))
                }
                else if(a%3 == 0){ // sex female
                    user.setFirstName("Troll")
                    user.setLastName("Troll")
                    user.setSex("female")
                    user.setBirthday(sdf!!.parse("1992-05-25"))
                } else { // sex non binary
                    user.setFirstName("JUAN")
                    user.setLastName("lopez")
                    user.setSex("non-binary")
                    user.setBirthday(sdf!!.parse("1993-11-01"))
                }
                listUsers += user
            }
            userDao.insertAll(listUsers)
        }
        fun delete(userDao: UserDao){
            userDao.deleteAll(listUsers)
            Log.d("DELETING SIZE: ", listUsers.size.toString())
/*            try {
                listUsers.forEachIndexed({
                    index, user
                    ->
                    run {
                        try {
                            Log.d("deleting...", user.toString())
                            (listUsers as ArrayList<User>).removeAt(index)
                            userDao.delete(user)
                        }catch(e: Exception) {
                            Log.d("ERROR DELETING: ", e.message)

                        }
                    }
                })
            } catch(e: Exception) {
                Log.d("ERROR: ", e.message)

            }*/
        }
    }

}
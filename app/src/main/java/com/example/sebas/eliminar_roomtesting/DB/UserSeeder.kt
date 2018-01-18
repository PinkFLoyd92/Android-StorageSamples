package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.RoomDatabase
import android.util.Log
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User

/**
 * Created by sebas on 1/18/18.
 */

public class UserSeeder {
    companion object {
        var listUsers : List<User> = mutableListOf<User>()
        fun seed(userDao: UserDao){
            listUsers = userDao.getAll()
            delete(userDao)
            for (a in 1..10){
                val user : User = User()
                user.setAge(10)
                if(a%2 == 0) { // sex male
                    user.setFirstName("Sebas")
                    user.setLastName("Caceres")
                    user.setSex("male")
                }
                else if(a%3 == 0){ // sex female
                    user.setFirstName("Troll")
                    user.setLastName("Troll")
                    user.setSex("female")
                } else { // sex non binary
                    user.setFirstName("JUAN")
                    user.setLastName("lopez")
                    user.setSex("non-binary")
                }
                listUsers += user
            }
            userDao.insertAll(listUsers)
        }
        fun delete(userDao: UserDao){
            userDao.deleteAll(listUsers)
            listUsers.forEachIndexed({
                index, user
                        ->
                run {
                    Log.d("deleting...", user.toString())
                    (listUsers as ArrayList<User>).removeAt(index)
                    userDao.delete(user)
                }
            })
        }
    }

}
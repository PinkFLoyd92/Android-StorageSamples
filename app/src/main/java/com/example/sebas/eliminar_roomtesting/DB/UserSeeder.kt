package com.example.sebas.eliminar_roomtesting.DB

import android.arch.persistence.room.RoomDatabase
import com.example.sebas.eliminar_roomtesting.DB.DAO.UserDao
import com.example.sebas.eliminar_roomtesting.DB.Model.User

/**
 * Created by sebas on 1/18/18.
 */

public class UserSeeder {
    companion object {
        var listUsers : List<User> = emptyList<User>()
        fun seed(userDao: UserDao){
            delete(userDao)
            for (a in 1..10){
                val user : User = User()
                user.setAge(10)
                if(a%2 == 0) {
                    user.setFirstName("Sebas")
                    user.setLastName("Caceres")
                    user.setSex("male")
                }
                else {
                    user.setFirstName("Troll")
                    user.setLastName("Troll")
                    user.setSex("female")
                }
                listUsers += user
            }
            userDao.insertAll(listUsers)
        }
        fun delete(userDao: UserDao){
            listUsers.forEachIndexed({
                index, user
                        -> userDao.delete(user)
            })
        }
    }

}
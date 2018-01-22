package com.example.sebas.eliminar_roomtesting.DB.DAO

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.database.Cursor
import com.example.sebas.eliminar_roomtesting.DB.Model.User


/**
 * Created by sebas on 1/18/18.
 */

@Dao interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll() : List<User>

    @Query("SELECT first_name,sex, count(sex) from user group by sex")
    fun getGroupedUsers() : Cursor

//    @Query("SELECT * FROM user where first_name LIKE  :arg0 AND last_name LIKE :arg1")
//    fun findByName(first_name: String , last_name:String ) : List<User>

    @Query("SELECT COUNT(*) from user")
    fun countUsers() : Int

    @Insert
    fun insertAll(users : List<User>);

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteAll(users: List<User>)

    @Query("SELECT * from user where first_name LIKE :arg0")
    fun getUsersByName(first_name: String): List<User>

    @Query("SELECT * from user where sex=:arg0")
    fun getUsersByGender(sex: String): List<User>

    @Query("SELECT COUNT(*) from user where sex=:arg0")
    fun countUsersByGender(sex: String): Int
}

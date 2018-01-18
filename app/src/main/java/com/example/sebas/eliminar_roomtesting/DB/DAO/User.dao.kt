package com.example.sebas.eliminar_roomtesting.DB.DAO

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.sebas.eliminar_roomtesting.DB.Model.User


/**
 * Created by sebas on 1/18/18.
 */

@Dao interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll() : List<User>;

//    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
//    fun findByName(firstName: String , lastName:String ) : List<User>;

    @Query("SELECT COUNT(*) from user")
    fun countUsers() : Int

    @Insert
    fun insertAll(users : List<User>);

    @Delete
    fun delete(user: User)
}

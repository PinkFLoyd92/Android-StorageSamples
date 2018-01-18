package com.example.sebas.eliminar_roomtesting.DB.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by sebas on 1/18/18.
 */

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private var uid:Int? = null

    @ColumnInfo(name = "first_name")
    private var firstName : String = ""

    @ColumnInfo(name = "last_name")
    private var lastName: String = ""

    @ColumnInfo(name = "age")
    private var age: Int? = null;

    open fun getUid(): Int? {
        return uid;
    }

    open fun setUid(uid : Int){
        this.uid = uid
    }

    open fun getFirstName(): String? {
        return firstName;
    }

    open fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    open fun getLastName() : String {
        return this.lastName
    }

    open fun setLastName(lastName : String) {
        this.lastName = lastName
    }

    open fun getAge(): Int? {
        return age;
    }

    open fun setAge(age: Int?) {
        this.age = age
    }

}


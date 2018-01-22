package com.example.sebas.eliminar_roomtesting.DB.Model

import android.arch.persistence.room.*
import com.example.sebas.eliminar_roomtesting.DB.type_converters.DateConverter
import java.util.*

/**
 * Created by sebas on 1/18/18.
 */

@Entity(tableName = "user", indices = arrayOf(Index(value = "first_name", name = "name"), Index(value = "sex", name = "sex")))
public class User {

    @PrimaryKey(autoGenerate = true)
    private var uid:Int? = null

    @ColumnInfo(name = "first_name")
    private var firstName : String = ""

    @ColumnInfo(name = "last_name")
    private var lastName: String = ""

    @ColumnInfo(name = "sex")
    private var sex: String = ""

    @ColumnInfo(name = "age")
    private var age: Int? = null;

    @ColumnInfo(name = "birth_date")
    var birthDate: Date? = null

    fun getUid(): Int? {
        return uid;
    }

    fun setUid(uid : Int){
        this.uid = uid
    }

    fun getFirstName(): String? {
        return firstName;
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getLastName() : String {
        return this.lastName
    }

    fun setLastName(lastName : String) {
        this.lastName = lastName
    }

    fun setSex(sex: String) {
        this.sex = sex
    }

    fun getSex(): String? {
        return sex
    }

    fun getBirthDay() : Date? {
        return birthDate
    }

    fun setBirthday(birth_date: Date) {
        this.birthDate = birth_date
    }

    fun getAge(): Int? {
        return age
    }

    fun setAge(age: Int?) {
        this.age = age
    }

    override fun toString(): String {
        return "User firstName = '$firstName', lastName='$lastName', sex='$sex', age=$age)"
    }

}


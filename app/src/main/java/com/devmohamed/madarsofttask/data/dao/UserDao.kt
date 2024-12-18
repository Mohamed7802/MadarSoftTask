package com.devmohamed.madarsofttask.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devmohamed.madarsofttask.data.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>
}

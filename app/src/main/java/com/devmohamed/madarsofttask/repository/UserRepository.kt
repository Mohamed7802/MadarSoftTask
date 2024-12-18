package com.devmohamed.madarsofttask.repository

import com.devmohamed.madarsofttask.data.entity.User
import com.devmohamed.madarsofttask.data.dao.UserDao


class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = userDao.insert(user)
    suspend fun getAllUsers() = userDao.getAllUsers()
}

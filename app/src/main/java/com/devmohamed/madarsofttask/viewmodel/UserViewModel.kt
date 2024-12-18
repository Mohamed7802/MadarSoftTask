package com.devmohamed.madarsofttask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.devmohamed.madarsofttask.data.database.AppDatabase
import com.devmohamed.madarsofttask.data.entity.User
import com.devmohamed.madarsofttask.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()
    private val repository: UserRepository = UserRepository(userDao)

    // Insert a new user into the database
    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    // Fetch all users and provide them via callback
    fun getAllUsers(callback: (List<User>) -> Unit) {
        viewModelScope.launch {
            val users = repository.getAllUsers()
            callback(users)
        }
    }
}

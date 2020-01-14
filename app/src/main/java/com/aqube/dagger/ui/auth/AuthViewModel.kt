package com.aqube.dagger.ui.auth

import androidx.lifecycle.LiveData
import com.aqube.dagger.base.BaseViewModel
import com.aqube.dagger.base.Resource
import com.aqube.dagger.model.User
import javax.inject.Inject


class AuthViewModel @Inject constructor(val userRepository: UserRepository) : BaseViewModel() {

    fun authenticateUserWithId(userId: Int) {
        userRepository.get(userId)
    }

    fun observeUser(): LiveData<Resource<User>> {
        return userRepository.getUserResource()
    }
}
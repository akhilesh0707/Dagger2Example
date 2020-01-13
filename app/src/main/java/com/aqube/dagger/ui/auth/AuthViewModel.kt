package com.aqube.dagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.aqube.dagger.di.network.auth.AuthApi
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi?) : ViewModel() {
    val TAG: String = AuthViewModel::class.java.simpleName

    init {
        Log.d(TAG, "AuthViewModel is create successfully")
        if (authApi == null) {
            Log.d(TAG, "AuthApi is null")
        } else {
            Log.d(TAG, "AuthApi is not null")
        }
    }
}
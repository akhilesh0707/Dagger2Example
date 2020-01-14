package com.aqube.dagger.ui.auth

import android.util.Log
import com.aqube.dagger.base.BaseViewModel
import com.aqube.dagger.di.network.auth.AuthApi
import com.aqube.dagger.model.UserModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(val authApi: AuthApi) : BaseViewModel() {

    val TAG: String = AuthViewModel::class.java.simpleName
    private var compositeDisposable: CompositeDisposable? = null

    init {
        compositeDisposable = CompositeDisposable()
        getUser()
    }

    private fun getUser() {
        compositeDisposable?.add(
            authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        )

    }

    private fun handleResponse(userModel: UserModel) {
        Log.d(TAG, userModel.toString())
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, error.localizedMessage)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.clear()
        compositeDisposable = null
    }
}
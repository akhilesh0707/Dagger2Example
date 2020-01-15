package com.aqube.dagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.aqube.dagger.base.Resource
import com.aqube.dagger.di.network.auth.AuthApi
import com.aqube.dagger.model.User
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepository @Inject constructor() {
    private val result = MediatorLiveData<Resource<User>>()

    @Inject
    lateinit var authApi: AuthApi

    /**
     * Get a [User].
     */
    fun get(userId: Int) {
        try {

            result.value = Resource.Loading()
            val source =
                LiveDataReactiveStreams.fromPublisher<Resource<User>>(authApi.getUser(userId).onErrorReturn(
                    Function<Throwable, User> {
                        User(-1, "", "", "", "")
                    }).map(Function<User, Resource<User>> { user ->
                    if (user.id == -1) {
                        val exception = Exception("Error: user not found")
                        Resource.Failure(exception)
                    } else {
                        Resource.Success(user)
                    }
                }).subscribeOn(Schedulers.io())
                )

            result.addSource(source,
                Observer<Resource<User>> { user ->
                    result.value = user
                    result.removeSource(source)
                })
        } catch (e: Exception) {
            result.value = Resource.Failure(e)
        }
    }

    fun getUserResource(): LiveData<Resource<User>> {
        return result
    }
}
package com.aqube.dagger.di.network.auth

import com.aqube.dagger.model.UserModel
import com.aqube.dagger.util.GET_USER
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET(GET_USER)
    fun getUser(@Path("id") id: Int): Flowable<UserModel>
}
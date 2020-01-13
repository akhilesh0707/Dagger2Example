package com.aqube.dagger.di.auth

import androidx.lifecycle.ViewModel
import com.aqube.dagger.di.ViewModelKey
import com.aqube.dagger.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}